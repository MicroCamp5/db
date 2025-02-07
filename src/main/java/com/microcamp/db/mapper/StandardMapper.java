package com.microcamp.db.mapper;

import com.microcamp.db.domain.Customer;
import com.microcamp.db.dto.CustomerDto;

public interface StandardMapper<S, T> {
    T toDto(S entity);
}
