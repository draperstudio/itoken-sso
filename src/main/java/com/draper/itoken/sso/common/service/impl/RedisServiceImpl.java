package com.draper.itoken.sso.common.service.impl;

import com.draper.itoken.sso.common.execption.RedisConnectException;
import com.draper.itoken.sso.common.service.RedisService;
import com.draper.itoken.sso.domain.RedisInfo;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author draper_hxy
 */
public class RedisServiceImpl implements RedisService {

    private RedisProperties.Jedis jedisPool;

    @Override
    public List<RedisInfo> getRedisInfo() throws RedisConnectException {
        return null;
    }

    @Override
    public Map<String, Object> getKeysSize() throws RedisConnectException {
        return null;
    }

    @Override
    public Map<String, Object> getMemoryInfo() throws RedisConnectException {
        return null;
    }

    @Override
    public Set<String> getKeys(String pattern) throws RedisConnectException {
        return null;
    }

    @Override
    public String get(String key) throws RedisConnectException {
        return null;
    }

    @Override
    public String set(String key, String value) throws RedisConnectException {
        return null;
    }

    @Override
    public String set(String key, String value, Long milliscends) throws RedisConnectException {
        return null;
    }

    @Override
    public Long del(String... key) throws RedisConnectException {
        return null;
    }

    @Override
    public Boolean exists(String key) throws RedisConnectException {
        return null;
    }

    @Override
    public Long pttl(String key) throws RedisConnectException {
        return null;
    }

    @Override
    public Long pexpire(String key, Long milliscends) throws RedisConnectException {
        return null;
    }

    @Override
    public Long zadd(String key, Double score, String member) throws RedisConnectException {
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max) throws RedisConnectException {
        return null;
    }

    @Override
    public Long zremrangeByScore(String key, String start, String end) throws RedisConnectException {
        return null;
    }

    @Override
    public Long zrem(String key, String... members) throws RedisConnectException {
        return null;
    }
}
