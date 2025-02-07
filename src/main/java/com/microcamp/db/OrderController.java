package com.microcamp.db;


import com.microcamp.db.dto.OrderCustomerDto;
import com.microcamp.db.dto.OrderDto;
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
    public Page<OrderCustomerDto> orders(@ParameterObject Pageable pageable){
        return orderService.findAll(pageable);
    }

    @PostMapping
    public OrderDto create(@Valid @RequestBody OrderDto order){

        return orderService.save(order);
    }

}
