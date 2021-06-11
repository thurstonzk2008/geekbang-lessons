package org.geektimes.projects.spring.cloud.service.bus;

import org.springframework.cloud.bus.BusBridge;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 利用redis实现spring cloud bus
 *
 * @author zhuhk
 * @create 2021-06-11 11:35 上午
 * @Version 1.0
 **/
public class RedisBusBridge implements BusBridge {
    private final StreamBridge streamBridge;

    private final BusProperties properties;

    public RedisBusBridge(StreamBridge streamBridge, BusProperties properties) {
        this.streamBridge = streamBridge;
        this.properties = properties;
    }

    @Override
    public void send(RemoteApplicationEvent event) {
        // TODO: configurable mimetype?
        this.streamBridge.send(properties.getDestination(), MessageBuilder.withPayload(event).build());
    }


    }
}
