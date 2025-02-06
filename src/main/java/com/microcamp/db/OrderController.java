package com.microcamp.db;


import com.microcamp.db.dto.OrderDto;
import com.microcamp.db.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/customer/{customerId}")
    public List<OrderDto> orders(@PathVariable Long customerId){
        return orderService.findByCustomerId(customerId);
    }
}
