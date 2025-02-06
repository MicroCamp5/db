package com.microcamp.db;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.repository.CustomerRepository;
import com.microcamp.db.repository.ShopOrderRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitOrderComponent {
    private final ShopOrderRepository shopOrderRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        if (shopOrderRepository.count() == 0) {
            Customer customer = new Customer("Krzysztof", "krzszy", null);
//        Customer customer2 = new Customer("Krzysztof", "krzszy", null);
            Customer customer1 = customerRepository.save(customer);
            Customer customer2 = customerRepository.save(new Customer("Ziutek", "ziuzut", null));

            shopOrderRepository.save(createShopOrder(customer));
            shopOrderRepository.save(createShopOrder(customer));
            shopOrderRepository.save(createShopOrder(customer2));
        }
    }

    private static ShopOrder createShopOrder(Customer customer) {
        return new ShopOrder( "My oder", customer );
    }
}
