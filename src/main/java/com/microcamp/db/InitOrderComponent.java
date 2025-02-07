package com.microcamp.db;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.repository.CustomerRepository;
import com.microcamp.db.repository.ShopOrderRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InitOrderComponent {
    private final ShopOrderRepository shopOrderRepository;
    private final CustomerRepository customerRepository;

    @EventListener
    public void init(ContextRefreshedEvent ctxStartEvt) {
        if (customerRepository.count() == 0) {
            Customer customer = new Customer("Krzysztof", "krzszy", null);
//        Customer customer2 = new Customer("Krzysztof", "krzszy", null);
            Customer customer1 = customerRepository.save(customer);
            Customer customer2 = customerRepository.save(new Customer("Ziutek", "ziuzut", null));

            shopOrderRepository.save(createShopOrder(customer));
            shopOrderRepository.save(createShopOrder(customer));
            shopOrderRepository.save(createShopOrder(customer2));
        }else {
            Customer customer = customerRepository.findById(1L).orElseThrow();

            for (int i = 0; i < 50; i++) {
                shopOrderRepository.save(createShopOrder(customer));
            }
        }
    }

    private static ShopOrder createShopOrder(Customer customer) {
        return new ShopOrder( "My oder", customer );
    }
}
