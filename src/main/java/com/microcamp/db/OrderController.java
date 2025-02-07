package com.microcamp.db;


import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.dto.OrderCustomerDto;
import com.microcamp.db.dto.OrderDto;
import com.microcamp.db.service.OrderCriteria;
import com.microcamp.db.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/customer/{customerId}")
    public List<OrderDto> ordersCustomer(@PathVariable Long customerId){
        return orderService.findByCustomerId(customerId);
    }

    @GetMapping
    public Page<OrderDto> orders(@ParameterObject OrderCriteria orderCriteria, @ParameterObject Pageable pageable){
        return orderService.findAll(orderCriteria, pageable);
    }

    @PostMapping
    public OrderDto create(@Valid @RequestBody OrderDto order){

        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public OrderDto update(@PathVariable() Long id, @Valid @RequestBody OrderDto order){
        order.setId(id);
        return orderService.save(order);
    }


}
