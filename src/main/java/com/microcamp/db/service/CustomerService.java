package com.microcamp.db.service;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.dto.CustomerDto;
import com.microcamp.db.mapper.CustomerMapper;
import com.microcamp.db.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto).toList();
    }

    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow();
    }
}
