package com.microcamp.db;

import com.microcamp.db.dto.CustomerDto;
import com.microcamp.db.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("")
    public List<CustomerDto> listCustomer(){
     return  customerService.findAll();
    }
    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable(value = "id") Long id){
       return customerService.findById(id);
    }


}
