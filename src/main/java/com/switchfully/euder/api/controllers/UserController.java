package com.switchfully.euder.api.controllers;

import com.switchfully.euder.api.dtos.CustomerDto;
import com.switchfully.euder.api.dtos.CustomerDtoCreate;
import com.switchfully.euder.api.mappers.CustomerMapper;
import com.switchfully.euder.domain.entities.user.User;
import com.switchfully.euder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final CustomerMapper customerMapper;

    @Autowired
    public UserController(UserService userService, CustomerMapper customerMapper) {
        this.userService = userService;
        this.customerMapper = customerMapper;
    }

    //TODO add Admin user restrictions access
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomer() {
        LOGGER.info("Getting all the Customers");
        return customerMapper.toDto(userService.getAllCustomer());
    }


    //TODO add Admin user restrictions access
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getOneCustomerById(@PathVariable("id") String id) {
        LOGGER.info("Getting one Customer with UUID: " + id);
        UUID uuid = UUID.fromString(id);
        return customerMapper.toDto(userService.getOneCustomerById(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createUserCustomer(@RequestBody CustomerDtoCreate customerDtoCreate) {
        LOGGER.info("Creating a Customer");
        User userToInsert = customerMapper.toEntity(customerDtoCreate);
        LOGGER.info("Inserting a new Customer with UUID " + userToInsert.getId());
        return customerMapper.toDto(userService.createUser(userToInsert));
    }
}
