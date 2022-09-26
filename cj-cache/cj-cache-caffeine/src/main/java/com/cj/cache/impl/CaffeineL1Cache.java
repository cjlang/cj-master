package com.cj.cache.impl;

import com.github.benmanes.caffeine.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 一级缓存：提供给二级缓存Redis使用
 */
@Service
public class CaffeineL1Cache {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Cache<String, Object> caffeineCache;

    public boolean put(String key, Object value) {
        try {
            caffeineCache.put(key,value);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    public boolean put(String key, Object value, long time) {
        try {
            caffeineCache.put(key,value);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    public boolean expire(String key, long time) {
        return false;
    }

    public long getExpire(String key) {
        return 0;
    }

    public boolean hasKey(String key) {
        try {
            Object o=caffeineCache.getIfPresent(key);
            return o!=null?true:false;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    public Object get(String key) {
        return caffeineCache.getIfPresent(key);
    }

    public boolean del(String key) {
        try {
            caffeineCache.invalidate(key);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }
}
