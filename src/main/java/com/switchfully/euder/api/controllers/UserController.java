package com.switchfully.euder.api.controllers;

import com.switchfully.euder.api.dtos.CustomerDtoCreate;
import com.switchfully.euder.api.mappers.CustomerMapper;
import com.switchfully.euder.domain.entities.customer.Customer;
import com.switchfully.euder.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final CustomerService customerService;
    private final  CustomerMapper customerMapper;

    @Autowired
    public UserController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDtoCreate createCustomer(@RequestBody CustomerDtoCreate customerDtoCreate){
        LOGGER.info("Creating a Customer");
        Customer customerToInsert = customerMapper.toEntity(customerDtoCreate);
        LOGGER.info("Inserting a new book with UUID "+ customerToInsert.getId());
        return customerMapper.toDto(customerService.createCustomer(customerToInsert));
    }
}
