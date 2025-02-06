package com.microcamp.db.mapper;

import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

   @Mapping(target = "customerId", source = "customer.id")
    OrderDto toDto(ShopOrder entity);
}
