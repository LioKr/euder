package com.switchfully.euder.domain.database;

import com.switchfully.euder.domain.entities.user.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDb {
    private final Map<java.util.UUID, User> customers = new HashMap<>();

    public User createUser(User newUser) {
        customers.put(newUser.getId(), newUser);
        return customers.get(newUser.getId());
    }
}
