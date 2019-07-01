package com.ecms.cums.utils.redis;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

final class RedisHashOperations {
    private RedisTemplate<String, String> redisTemplate;

    public RedisHashOperations(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> T hGet(String key, String field, Class<T> targetClass) {
        byte[] result = (byte[])this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.hGet(key.getBytes(), field.getBytes());
        });
        return result == null ? null : ObjectSerialization.deserialize(result, targetClass);
    }

    public <T> boolean hSet(String key, String field, T obj) {
        byte[] value = ObjectSerialization.serialize(obj);
        return (Boolean)this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.hSet(key.getBytes(), field.getBytes(), value);
        });
    }

    public <T> void hSetWithExpire(String key, String field, T obj, long expireTime) {
        byte[] value = ObjectSerialization.serialize(obj);
        this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
            connection.hSet(key.getBytes(), field.getBytes(), value);
            connection.expire(key.getBytes(), expireTime);
            return null;
        });
    }

    public <T> List<T> hGetList(String key, String field, Class<T> targetClass) {
        byte[] result = (byte[])this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.hGet(key.getBytes(), field.getBytes());
        });
        return result == null ? null : ObjectSerialization.deserializeList(result, targetClass);
    }

    public <T> Map<String, T> hMGet(String key, Collection<String> fields, Class<T> targetClass) {
        List<byte[]> byteFields = (List)fields.stream().map(String::getBytes).collect(Collectors.toList());
        byte[][] queryFields = new byte[byteFields.size()][];
        byteFields.toArray(queryFields);
        List<byte[]> cache = (List)this.redisTemplate.execute((RedisCallback<T>) (connection) -> {
            return (T) connection.hMGet(key.getBytes(), queryFields);
        });
        Map<String, T> results = new HashMap(16);
        Iterator<String> it = fields.iterator();
        int index = 0;

        while(it.hasNext()) {
            String k = (String)it.next();
            if (cache.get(index) == null) {
                ++index;
            } else {
                results.put(k, ObjectSerialization.deserialize((byte[])cache.get(index), targetClass));
                ++index;
            }
        }

        return results;
    }

    public <T> void hMSet(String key, Map<String, T> values) {
        Map<byte[], byte[]> byteValues = new HashMap(16);
        Iterator var4 = values.entrySet().iterator();

        while(var4.hasNext()) {
            Entry<String, T> value = (Entry)var4.next();
            byteValues.put(((String)value.getKey()).getBytes(), ObjectSerialization.serialize(value.getValue()));
        }
        this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
            connection.hMSet(key.getBytes(), byteValues);
            return null;
        });
    }
}

