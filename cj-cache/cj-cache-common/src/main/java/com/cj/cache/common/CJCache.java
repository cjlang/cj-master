package com.cj.cache.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface CJCache {

    boolean put(String key, Object value);
    boolean put(String key, Object value, long time);
    boolean expire(String key, long time);
    long getExpire(String key);
    boolean hasKey(String key);
    Object get(String key);
    boolean del(String key);

    boolean put(String key, Object value,boolean L1);
    boolean put(String key, Object value, long time,boolean L1);
    boolean expire(String key, long time,boolean L1);
    long getExpire(String key,boolean L1);
    boolean hasKey(String key,boolean L1);
    Object get(String key,boolean L1);
    boolean del(String key,boolean L1);
}
