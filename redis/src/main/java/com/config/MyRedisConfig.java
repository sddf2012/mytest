package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "redis")
public class MyRedisConfig {
    private boolean allowInFlightCacheCreation;

    private boolean enableTransaction;

    private SingleConfig defaultCache;

    private Map<String, SingleConfig> caches;

    public boolean isAllowInFlightCacheCreation() {
        return allowInFlightCacheCreation;
    }

    public void setAllowInFlightCacheCreation(boolean allowInFlightCacheCreation) {
        this.allowInFlightCacheCreation = allowInFlightCacheCreation;
    }

    public boolean isEnableTransaction() {
        return enableTransaction;
    }

    public void setEnableTransaction(boolean enableTransaction) {
        this.enableTransaction = enableTransaction;
    }

    public SingleConfig getDefaultCache() {
        return defaultCache;
    }

    public void setDefaultCache(SingleConfig defaultCache) {
        this.defaultCache = defaultCache;
    }

    public Map<String, SingleConfig> getCaches() {
        return caches;
    }

    public void setCaches(Map<String, SingleConfig> caches) {
        this.caches = caches;
    }
}
