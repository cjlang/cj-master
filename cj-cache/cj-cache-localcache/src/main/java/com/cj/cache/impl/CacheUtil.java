package com.cj.cache.impl;

import com.cj.cache.common.CJCache;
import com.github.benmanes.caffeine.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheUtil implements CJCache {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Cache<String, Object> caffeineCache;

    @Override
    public boolean put(String key, Object value) {
        try {
            caffeineCache.put(key,value);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean put(String key, Object value, long time) {
        try {
            caffeineCache.put(key,value);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean expire(String key, long time) {
        return false;
    }

    @Override
    public long getExpire(String key) {
        return 0;
    }

    @Override
    public boolean hasKey(String key) {
        try {
            Object o=caffeineCache.getIfPresent(key);
            return o!=null?true:false;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public Object get(String key) {
        return caffeineCache.getIfPresent(key);
    }

    @Override
    public boolean del(String key) {
        try {
            caffeineCache.invalidate(key);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean put(String key, Object value,boolean L1) {
        try {
            caffeineCache.put(key,value);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean put(String key, Object value, long time,boolean L1) {
        try {
            caffeineCache.put(key,value);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public boolean expire(String key, long time,boolean L1) {
        return false;
    }

    @Override
    public long getExpire(String key,boolean L1) {
        return 0;
    }

    @Override
    public boolean hasKey(String key,boolean L1) {
        try {
            Object o=caffeineCache.getIfPresent(key);
            return o!=null?true:false;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }

    @Override
    public Object get(String key,boolean L1) {
        return caffeineCache.getIfPresent(key);
    }

    @Override
    public boolean del(String key,boolean L1) {
        try {
            caffeineCache.invalidate(key);
            return true;
        } catch (Throwable e) {
            logger.error("caffeine操作异常:",e);
            return false;
        }
    }
}
