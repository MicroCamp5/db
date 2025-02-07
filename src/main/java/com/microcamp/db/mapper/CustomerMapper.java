package com.microcamp.db.mapper;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends StandardMapper<Customer,CustomerDto > {

    default Customer fromId(Long id){
        if(id == null){
            return null;
        }
        Customer customer = new Customer(id);
        return customer;
    }
}
