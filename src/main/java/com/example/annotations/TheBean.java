package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class TheBean {
    private ApplicationEventPublisher eventPublisher;

    public ApplicationEventPublisher getApplicationEventPublisher() {
        return eventPublisher;
    }

    @Autowired
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(Object event) {
        eventPublisher.publishEvent(event);
    }

}