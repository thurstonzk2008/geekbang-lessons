package org.geektimes.projects.spring.cloud.bus.redis.subscriber;

/**
 * redis 订阅信息处理接口
 * @param <T>
 */
public interface MessageHandler<T> {

    void onMessage(T t, String pattern);

    String getTopic();
}
