package com.microcamp.db.mapper;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CustomerMapper.class)
public interface OrderMapper extends StandardMapper<ShopOrder, OrderDto>{
    @Override
    @Mapping(target = "customerId", source = "customer.id")
    OrderDto toDto(ShopOrder entity);


    @Mapping(target = "customer", source = "customerId")
    ShopOrder toEntity(OrderDto order);
}
