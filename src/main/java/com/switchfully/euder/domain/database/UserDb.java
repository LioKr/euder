package com.switchfully.euder.domain.database;

import com.switchfully.euder.domain.entities.user.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserDb {
    private final Map<UUID, User> customers = new HashMap<>();

    public User createUser(User newUser) {
        customers.put(newUser.getId(), newUser);
        return customers.get(newUser.getId());
    }
}
