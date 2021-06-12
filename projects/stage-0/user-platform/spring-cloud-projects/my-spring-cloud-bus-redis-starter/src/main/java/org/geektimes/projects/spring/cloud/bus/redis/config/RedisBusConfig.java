package org.geektimes.projects.spring.cloud.bus.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.bus.BusBridge;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.geektimes.projects.spring.cloud.bus.redis.publisher.RedisBusBridge;
import org.geektimes.projects.spring.cloud.bus.redis.subscriber.MessageHandler;
import org.geektimes.projects.spring.cloud.bus.redis.subscriber.MessageListenerAdapters;
import org.geektimes.projects.spring.cloud.bus.redis.subscriber.RemoteApplicationEventMessageHandler;

import java.util.List;
import java.util.Map;

/**
 * Redis Bus 的相关的自动装配
 */
@ConditionalOnClass(RemoteApplicationEvent.class)
@Configuration
public class RedisBusConfig {

    @Bean
    public MessageListenerAdapters messageListenerAdapters(List<MessageHandler<?>> handlers,
                                                            RedisSerializer<?> redisSerializer) {
        return new MessageListenerAdapters(handlers, redisSerializer);
    }

    /**
     * RemoteApplicationEvent 的 {@link MessageHandler} 实现
     * 从 Redis 接收数据，并且发送本地事件
     */
    @Bean
    public RemoteApplicationEventMessageHandler remoteApplicationEventMessageHandler(ApplicationEventPublisher publisher,
                                                                                     BusProperties properties,
                                                                                     ServiceMatcher matcher) {
        return new RemoteApplicationEventMessageHandler(publisher, properties,matcher);
    }

    /**
     * 将订阅器绑定到容器
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapters adapters) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        Map<String, MessageListenerAdapter> adapterMap = adapters.getAdapterMap();
        adapterMap.forEach((topic,adapter) ->{
            container.addMessageListener(adapter, new PatternTopic(topic));
        });
        return container;
    }

    @Bean
    public BusBridge redisBusBridge(BusProperties properties, RedisTemplate<String,Object> stringObjectRedisTemplate){
        return new RedisBusBridge(properties, stringObjectRedisTemplate);
    }
}
