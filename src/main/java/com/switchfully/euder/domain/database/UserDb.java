package com.switchfully.euder.domain.database;

import com.switchfully.euder.domain.entities.user.Role;
import com.switchfully.euder.domain.entities.user.User;
import com.switchfully.euder.infrastructure.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserDb {
    private final Map<java.util.UUID, User> customers = new HashMap<>();

    public User createUser(User newUser) {
        customers.put(newUser.getId(), newUser);
        return customers.get(newUser.getId());
    }

    public List<User> getAllCustomer() {
        return customers.values().stream()
                .filter(user -> user.getRole() == Role.CUSTOMER)
                .collect(Collectors.toList());
    }

    public User getOneCustomerById(UUID uuid) {
        if (!customers.containsKey(uuid)) throw new UserNotFoundException("Cannot find User with Id matching: " + uuid);
        return customers.get(uuid);
    }

    public List<User> getAllUser() {
        return new ArrayList<>(customers.values());
    }
}
