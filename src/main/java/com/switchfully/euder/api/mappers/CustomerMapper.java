package com.switchfully.euder.api.mappers;

import com.switchfully.euder.api.dtos.CustomerDtoCreate;
import com.switchfully.euder.domain.entities.user.Role;
import com.switchfully.euder.domain.entities.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerMapper.class);

    public User toEntity(CustomerDtoCreate customerDtoCreate) {
        LOGGER.info("Returning Customer entity based on CustomerDtoCreate");
        if (customerDtoCreate == null)
            throw new IllegalArgumentException("Cannot create Customer entity, null argument provided.");
        return new User(customerDtoCreate.getFirstname(),
                customerDtoCreate.getLastname(),
                customerDtoCreate.getEmail(),
                customerDtoCreate.getAddress(),
                customerDtoCreate.getPhoneNumber(),
                Role.CUSTOMER);
    }

    public CustomerDtoCreate toDto(User user) {
        LOGGER.info("Returning CustomerDtoCreate based on Customer entity");
        if (user == null)
            throw new IllegalArgumentException("Cannot create CustomerDtoCreate, null argument provided.");
        return new CustomerDtoCreate()
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setPhoneNumber(user.getPhoneNumber());
    }
}
