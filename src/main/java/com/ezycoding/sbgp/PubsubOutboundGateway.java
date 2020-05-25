package com.ezycoding.sbgp;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
public interface PubsubOutboundGateway {
    void sendToPubsub(Object obj);
}
