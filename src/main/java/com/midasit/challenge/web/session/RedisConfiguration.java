package com.midasit.challenge.web.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.net.URISyntaxException;

@Configuration
public class RedisConfiguration {
    @Bean
    public JedisConnectionFactory connectionFactory() throws URISyntaxException {
        JedisConnectionFactory redis = new JedisConnectionFactory();
        redis.setHostName("127.0.0.1");
        redis.setPort(6379);
        return redis;
    }
}