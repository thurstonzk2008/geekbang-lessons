package org.geektimes.projects.spring.cloud.bus.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisConfig.class,RedisBusConfig.class})
public class RedisBusAutoConfig {

}
