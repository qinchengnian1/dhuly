package com.ecms.cums.utils.redis;

import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
    private RedisTemplate<String, String> redisTemplate;
    private RedisStringOperations strOps;
    private RedisObjectOperations objOps;
    private RedisListOperations listOps;
    private RedisHashOperations hashOps;
    @Resource(
            name = "redisTemplate"
    )
    private SetOperations<String, String> setOps;
    @Resource(
            name = "redisTemplate"
    )
    private ZSetOperations<String, String> zsetOps;

    @Autowired
    public RedisUtils(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.strOps = new RedisStringOperations(redisTemplate);
        this.objOps = new RedisObjectOperations(redisTemplate);
        this.listOps = new RedisListOperations(redisTemplate);
        this.hashOps = new RedisHashOperations(redisTemplate);
    }

    public boolean hasKey(String key) {
        return this.redisTemplate.hasKey(key);
    }

    public void deleteKey(String... keys) {
        Collection<String> listKey = Arrays.asList(keys);
        this.deleteKeys(listKey);
    }

    public void deleteKeys(Collection<String> listKey) {
        this.redisTemplate.delete(listKey);
    }

    public Long getExpire(String key) {
        return this.redisTemplate.getExpire(key);
    }

    public RedisStringOperations getStrOps() {
        return this.strOps;
    }

    public RedisObjectOperations getObjOps() {
        return this.objOps;
    }

    public RedisListOperations getListOps() {
        return this.listOps;
    }

    public RedisHashOperations getHashOps() {
        return this.hashOps;
    }

    public SetOperations<String, String> getSetOps() {
        return this.setOps;
    }

    public ZSetOperations<String, String> getZsetOps() {
        return this.zsetOps;
    }

    public String toDynamicKey(String perfixKey, Object dynamicKey) {
        return perfixKey + ":" + dynamicKey;
    }
}

