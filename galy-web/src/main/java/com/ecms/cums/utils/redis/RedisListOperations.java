package com.ecms.cums.utils.redis;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public final class RedisListOperations {
    private RedisTemplate<String, String> redisTemplate;

    public RedisListOperations(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> List<T> get(String key, Class<T> targetClass) {
        byte[] result = (byte[])this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.get(key.getBytes());
        });
        return result == null ? null : ObjectSerialization.deserializeList(result, targetClass);
    }

    public <T> void set(String key, List<T> list) {
        byte[] value = ObjectSerialization.serializeList(list);
        this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
            connection.set(key.getBytes(), value);
            return null;
        });
    }

    public <T> void setWithExpire(String key, List<T> list, long expireTime) {
        byte[] value = ObjectSerialization.serializeList(list);
        this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
            connection.setEx(key.getBytes(), expireTime, value);
            return null;
        });
    }

    public <T> T lindex(String key, int index, Class<T> targetClass) {
        byte[] value = (byte[])this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.lIndex(key.getBytes(), (long)index);
        });
        return ObjectSerialization.deserialize(value, targetClass);
    }

    public <T> List<T> lRange(String key, int start, int end, Class<T> targetClass) {
        List<byte[]> value = (List)this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.lRange(key.getBytes(), (long)start, (long)end);
        });
        return (List)value.stream().map((record) -> {
            return ObjectSerialization.deserialize(record, targetClass);
        }).collect(Collectors.toList());
    }

    public <T> void lPush(String key, T obj) {
        byte[] value = ObjectSerialization.serialize(obj);
        this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.lPush(key.getBytes(), new byte[][]{value});
        });
    }

    public <T> void lPush(String key, List<T> objList) {
        List<byte[]> byteFields = (List)objList.stream().map(ObjectSerialization::serialize).collect(Collectors.toList());
        byte[][] values = new byte[byteFields.size()][];
        this.redisTemplate.execute((RedisCallback<Long>) (connection) -> {
            return connection.lPush(key.getBytes(), values);
        });
    }
}
