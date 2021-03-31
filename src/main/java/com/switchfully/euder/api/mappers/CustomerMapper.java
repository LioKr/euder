package com.switchfully.euder.api.mappers;

import com.switchfully.euder.api.dtos.CustomerDto;
import com.switchfully.euder.api.dtos.CustomerDtoCreate;
import com.switchfully.euder.domain.entities.user.Role;
import com.switchfully.euder.domain.entities.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public CustomerDto toDto(User user) { //QUESTION is it a bad idea to return the Id?
        LOGGER.info("Returning CustomerDtoCreate based on Customer entity");
        if (user == null)
            throw new IllegalArgumentException("Cannot create CustomerDtoCreate, null argument provided.");
        return new CustomerDto()
                .setId(user.getId())
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setPhoneNumber(user.getPhoneNumber());
    }

    public List<CustomerDto> toDto(List<User> users) {
        LOGGER.info("Returning list of CustomerDto based on list of Customer entity");
        if (users == null)
            throw new IllegalArgumentException("Cannot create list of CustomerDtoCreate, null argument provided.");
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
