package com.microcamp.db.service;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.dto.CustomerDto;
import com.microcamp.db.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    private static CustomerDto map(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setDateBirth(customer.getDateBirth());
        customerDto.setName(customer.getName());
        customerDto.setUniqueKey(customer.getUniqueKey());
        return customerDto;
    }

    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(customer -> map(customer)).toList();
    }

    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> map(customer))
                .orElseThrow();
    }
}
