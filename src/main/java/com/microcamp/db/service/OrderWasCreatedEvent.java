package com.microcamp.db.service;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderWasCreatedEvent extends ApplicationEvent {
    private final String name;

    public OrderWasCreatedEvent(OrderService orderService, String name) {
        super(orderService);
        this.name = name;
    }
}
