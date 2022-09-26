package com.cj.cache.impl;

import com.cj.cache.common.CJCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class CacheUtil implements CJCache {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CaffeineL1Cache caffeineL1Cache;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean put(String key, Object value) {
        try {
            caffeineL1Cache.put(key,value);
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Throwable e) {
            logger.error("redis操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean put(String key, Object value, long time) {
        try {
            if (time > 0) {
                caffeineL1Cache.put(key, value, time);
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                caffeineL1Cache.put(key,value);
                put(key, value);
            }
            return true;
        } catch (Throwable e) {
            logger.error("redis异常:",e);
            return false;
        }
    }

    @Override
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                caffeineL1Cache.expire(key,time);
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable e) {
            logger.error("redis操作异常:",e);
            return false;
        }
    }

    @Override
    public long getExpire(String key) {
        return caffeineL1Cache.getExpire(key)>redisTemplate.getExpire(key, TimeUnit.SECONDS)?redisTemplate.getExpire(key, TimeUnit.SECONDS):caffeineL1Cache.getExpire(key);
    }

    @Override
    public boolean hasKey(String key) {
        try {
            return caffeineL1Cache.hasKey(key)?caffeineL1Cache.hasKey(key):redisTemplate.hasKey(key);
        } catch (Throwable e) {
            logger.error("redis操作异常:",e);
            return false;
        }
    }

    @Override
    public Object get(String key) {
        return caffeineL1Cache.get(key) != null ? caffeineL1Cache.get(key) : redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean del(String key) {
        try {
            return caffeineL1Cache.del(key) || redisTemplate.delete(key);
        } catch (Throwable e) {
            logger.error("redis操作异常:",e);
            return false;
        }
    }
    @Override
    public boolean put(String key, Object value,boolean L1) {
        try {
            caffeineL1Cache.put(key,value);
            if(!L1) redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Throwable e) {
            logger.error("redis操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean put(String key, Object value, long time,boolean L1) {
        try {
            if (time > 0) {
                caffeineL1Cache.put(key, value, time);
                if(!L1) redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                caffeineL1Cache.put(key,value);
                if(!L1) put(key, value,false);
            }
            return true;
        } catch (Throwable e) {
            logger.error("redis异常:",e);
            return false;
        }
    }

    @Override
    public boolean expire(String key, long time,boolean L1) {
        try {
            if (time > 0) {
                caffeineL1Cache.expire(key,time);
                if(!L1) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable e) {
            logger.error("redis操作异常:",e);
            return false;
        }
    }

    @Override
    public long getExpire(String key,boolean L1) {
        return L1?caffeineL1Cache.getExpire(key):redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasKey(String key,boolean L1) {
        return L1?caffeineL1Cache.hasKey(key):redisTemplate.hasKey(key);
    }

    @Override
    public Object get(String key,boolean L1) {
        return L1?caffeineL1Cache.get(key) : redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean del(String key,boolean L1) {
        return L1?caffeineL1Cache.del(key):redisTemplate.delete(key);
    }
}
