package com.ecms.cums.utils.redis;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public final class RedisObjectOperations {
    private RedisTemplate<String, String> redisTemplate;

    public RedisObjectOperations(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> T get(String key, Class<T> targetClass) {
        byte[] result = (byte[])this.redisTemplate.execute((RedisCallback<byte[]>) (connection) -> {
            return connection.get(key.getBytes());
        });
        return result == null ? null : ObjectSerialization.deserialize(result, targetClass);
    }

    public <T> void set(String key, T obj) {
        byte[] value = ObjectSerialization.serialize(obj);
        this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
            connection.set(key.getBytes(), value);
            return null;
        });
    }

    public <T> void setWithExpire(String key, T obj, long expireTime) {
        byte[] value = ObjectSerialization.serialize(obj);
        this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
            connection.setEx(key.getBytes(), expireTime, value);
            return null;
        });
    }
}
