package com.microcamp.db.service;

import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.dto.OrderCustomerDto;
import com.microcamp.db.dto.OrderDto;
import com.microcamp.db.mapper.OrderCustomerMapper;
import com.microcamp.db.mapper.OrderMapper;
import com.microcamp.db.repository.ShopOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ShopOrderRepository shopOrderRepository;
    private final OrderMapper orderMapper;
    private final OrderCustomerMapper orderCustomerMapper;

    @Transactional(readOnly = true)
    public List<OrderDto> findByCustomerId(Long customerId) {
        return shopOrderRepository.findByCustomerId(customerId)
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public Page<OrderCustomerDto> findAll(Pageable pageable) {
        return shopOrderRepository.findAllWithCustomer(pageable).map(orderCustomerMapper::toDto);
    }

    @Transactional
    public OrderDto save(OrderDto order) {
        ShopOrder savedOrder = shopOrderRepository.save(orderMapper.toEntity(order));
        return orderMapper.toDto(savedOrder);
    }
}
