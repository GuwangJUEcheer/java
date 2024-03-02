package cn.itcast.mp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setKeyValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValueByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
