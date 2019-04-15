package com.config;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
public class SingleConfig {
    private long ttl;

    private boolean usePrefix = true;

    private boolean cacheNullValues = false;

    private String prefix;

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    public boolean isUsePrefix() {
        return usePrefix;
    }

    public void setUsePrefix(boolean usePrefix) {
        this.usePrefix = usePrefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public RedisCacheConfiguration trans2RedisConfiguration() {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        config = config.entryTtl(Duration.ofSeconds(this.ttl));
        if (!this.usePrefix) {
            config = config.disableKeyPrefix();
        }
        if (!cacheNullValues) {
            config = config.disableCachingNullValues();
        }
        if (StringUtils.hasText(prefix)) {
            config = config.prefixKeysWith(prefix);
        }
        return config;
    }
}
