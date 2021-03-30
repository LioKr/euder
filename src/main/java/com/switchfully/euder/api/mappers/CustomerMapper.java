package com.switchfully.euder.api.mappers;

import com.switchfully.euder.api.controllers.UserController;
import com.switchfully.euder.api.dtos.CustomerDtoCreate;
import com.switchfully.euder.domain.entities.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerMapper.class);

    public Customer toEntity(CustomerDtoCreate customerDtoCreate) {
        LOGGER.info("Returning Customer entity based on CustomerDtoCreate");
        if(customerDtoCreate == null) throw new IllegalArgumentException("Cannot create Customer entity, null argument provided.");
        return new Customer(customerDtoCreate.getFirstname(),
                customerDtoCreate.getLastname(),
                customerDtoCreate.getEmail(),
                customerDtoCreate.getAddress(),
                customerDtoCreate.getPhoneNumber());
    }

    public CustomerDtoCreate toDto(Customer customer) {
        LOGGER.info("Returning CustomerDtoCreate based on Customer entity");
        if(customer == null) throw new IllegalArgumentException("Cannot create CustomerDtoCreate, null argument provided.");
        return new CustomerDtoCreate()
                .setFirstname(customer.getFirstname())
                .setLastname(customer.getLastname())
                .setEmail(customer.getEmail())
                .setAddress(customer.getAddress())
                .setPhoneNumber(customer.getPhoneNumber());
    }
}
