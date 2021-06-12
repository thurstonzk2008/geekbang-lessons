package org.geektimes.projects.spring.cloud.bus.redis.publisher;

import org.geektimes.projects.spring.cloud.bus.redis.message.RedisMessage;
import org.springframework.cloud.bus.BusBridge;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 接收本地的 {@link RemoteApplicationEvent}，并且通过 Redis 发送到消息总线
 */
@Component
public class RedisBusBridge implements BusBridge {

    private final BusProperties properties;

    private final RedisTemplate<String,Object> redisTemplate;


    public RedisBusBridge(BusProperties properties, RedisTemplate<String,Object> redisTemplate) {
        this.properties = properties;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void send(RemoteApplicationEvent event) {
        RedisMessage redisMessage = new RedisMessage();
        redisMessage.setClazz(event.getClass().getName());
        redisMessage.setPlayLoad(event);
        redisTemplate.convertAndSend(properties.getDestination(),redisMessage);
    }
}
