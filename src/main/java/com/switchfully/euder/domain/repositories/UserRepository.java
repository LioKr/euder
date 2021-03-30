package com.switchfully.euder.domain.repositories;

import com.switchfully.euder.domain.database.UserDb;
import com.switchfully.euder.domain.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private final UserDb userDb;

    @Autowired
    public UserRepository(UserDb userDb) {
        this.userDb = userDb;
    }

    public User createUser(User newUser) {
        return userDb.createUser(newUser);
    }
}
