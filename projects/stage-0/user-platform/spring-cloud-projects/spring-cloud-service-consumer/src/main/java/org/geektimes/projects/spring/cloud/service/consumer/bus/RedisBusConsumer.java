package org.geektimes.projects.spring.cloud.service.consumer.bus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.bus.BusBridge;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.cloud.bus.event.SentApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

import javax.print.attribute.standard.Destination;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-06-11 4:08 下午
 * @Version 1.0
 **/
public class RedisBusConsumer implements Consumer<RemoteApplicationEvent> {

    private final Log log = LogFactory.getLog(getClass());

    private final ApplicationEventPublisher publisher;

    private final ServiceMatcher serviceMatcher;

    private final ObjectProvider<BusBridge> busBridge;

    private final BusProperties properties;

    private final Destination.Factory destinationFactory;

    public RedisBusConsumer(ApplicationEventPublisher publisher, ServiceMatcher serviceMatcher,
                       ObjectProvider<BusBridge> busBridge, BusProperties properties, Destination.Factory destinationFactory) {
        this.publisher = publisher;
        this.serviceMatcher = serviceMatcher;
        this.busBridge = busBridge;
        this.properties = properties;
        this.destinationFactory = destinationFactory;
    }

    @Override
    public void accept(RemoteApplicationEvent event) {
        if (event instanceof AckRemoteApplicationEvent) {
            if (this.properties.getTrace().isEnabled() && !this.serviceMatcher.isFromSelf(event)
                    && this.publisher != null) {
                this.publisher.publishEvent(event);
            }
            // If it's an ACK we are finished processing at this point
            return;
        }

        if (log.isDebugEnabled()) {
            log.debug("Received remote event from bus: " + event);
        }

        if (this.serviceMatcher.isForSelf(event) && this.publisher != null) {
            if (!this.serviceMatcher.isFromSelf(event)) {
                this.publisher.publishEvent(event);
            }
            if (this.properties.getAck().isEnabled()) {
                AckRemoteApplicationEvent ack = new AckRemoteApplicationEvent(this, this.serviceMatcher.getBusId(),
                        destinationFactory.getDestination(this.properties.getAck().getDestinationService()),
                        event.getDestinationService(), event.getId(), event.getClass());
                this.busBridge.ifAvailable(bridge -> bridge.send(ack));
                this.publisher.publishEvent(ack);
            }
        }
        if (this.properties.getTrace().isEnabled() && this.publisher != null) {
            // We are set to register sent events so publish it for local consumption,
            // irrespective of the origin
            this.publisher.publishEvent(new SentApplicationEvent(this, event.getOriginService(),
                    event.getDestinationService(), event.getId(), event.getClass()));
        }
    }
}
