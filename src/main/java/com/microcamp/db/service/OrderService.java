package com.microcamp.db.service;

import com.microcamp.db.dto.OrderDto;
import com.microcamp.db.mapper.OrderMapper;
import com.microcamp.db.repository.ShopOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ShopOrderRepository shopOrderRepository;
    private final OrderMapper orderMapper;

    @Transactional(readOnly = true)
    public List<OrderDto> findByCustomerId(Long customerId) {
        return shopOrderRepository.findByCustomerId(customerId)
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
