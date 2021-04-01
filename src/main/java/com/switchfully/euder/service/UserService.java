package com.switchfully.euder.service;

import com.switchfully.euder.domain.entities.user.User;
import com.switchfully.euder.domain.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User newUser) {
        LOGGER.info("Inserting one User");
        return userRepository.createUser(newUser);
    }

    public List<User> getAllCustomer() {
        LOGGER.info("Getting all the User that are Customer");
        return userRepository.getAllCustomer();
    }

    public List<User> getAllUser() {
        LOGGER.info("Getting all the User");
        return userRepository.getAllUser();
    }

    public User getOneCustomerById(UUID uuid) {
        LOGGER.info("Getting one Customer based on Id");
        return userRepository.getOneCustomerById(uuid);
    }
}
