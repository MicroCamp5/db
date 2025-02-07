package com.microcamp.db.mapper;

import com.microcamp.db.domain.ShopOrder;
import com.microcamp.db.dto.OrderCustomerDto;
import com.microcamp.db.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface OrderCustomerMapper {

   OrderCustomerDto toDto(ShopOrder entity);
}
