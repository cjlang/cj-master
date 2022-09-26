package com.cj.cache.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineConfig {

    @Bean
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                // 数量上限
                .maximumSize(1000)
                // 过期机制
                .expireAfterAccess(5, TimeUnit.MINUTES)
                // 弱引用key
                .weakKeys()
                // 弱引用value
                .weakValues()
                // 剔除监听
                .build();
    }
}
