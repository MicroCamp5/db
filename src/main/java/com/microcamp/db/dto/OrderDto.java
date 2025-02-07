package com.microcamp.db.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderDto {


    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 255)
    private String name;

    @NotNull
    @Min(1)
    private Long customerId;


}
