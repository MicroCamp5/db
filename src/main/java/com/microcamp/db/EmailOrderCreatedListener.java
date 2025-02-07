package com.microcamp.db;

import com.microcamp.db.service.OrderWasCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailOrderCreatedListener {
    @EventListener
    public void on(OrderWasCreatedEvent event){
        log.info("Emails was sent {}", event.getName());
    }
}
