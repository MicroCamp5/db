package com.microcamp.db.dto;

import lombok.Data;

@Data
public class OrderCustomerDto {

    private Long id;

    private String name;

    private CustomerDto customer;


}
