package com.switchfully.euder.service;

import com.switchfully.euder.domain.database.UserDb;
import com.switchfully.euder.domain.entities.user.*;
import com.switchfully.euder.domain.repositories.UserRepository;
import com.switchfully.euder.infrastructure.exceptions.InvalidMailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {
    private UserService userService;
    private Email email1;
    private PhoneNumber phoneNumber1;
    private Address address1;
    private User user1;
    private java.util.UUID id1;

    @BeforeEach
    void init() {
        this.userService = new UserService(new UserRepository(new UserDb()));
        this.email1 = new Email("some1@exemple.com");
        this.phoneNumber1 = new PhoneNumber("0032456000001");
        this.address1 = new Address("street1", "1", "1000", "city1");
        this.user1 = new User("firstname1", "lastname1", email1, address1, phoneNumber1, Role.CUSTOMER);
        this.id1 = user1.getId();
    }

    @Test
    void createCustomer_givenCorrectParameter_thenReturnNewCustomer() {
        User actualResult = userService.createUser(user1);
        assertThat(actualResult.getId() == id1);
    }

    @Test
    void createCustomer_givenNullParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.createUser(new User(null, "lastname1", email1, address1, phoneNumber1, Role.CUSTOMER)));
        assertTrue(exception.getMessage().contains("Cannot create User"));
    }

    @Test
    void createCustomer_givenInvalidMailParameter_thenThrowIllegalArgumentException() {
        InvalidMailException exception = assertThrows(InvalidMailException.class, () -> userService.createUser(new User("firstname1", "lastname1", new Email("invalidMail"), address1, phoneNumber1, Role.CUSTOMER)));
        assertTrue(exception.getMessage().contains("Cannot create Email"));
    }

    @Test
    void createCustomer_givenInvalidAddressParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.createUser(new User("firstname1", "lastname1", email1, new Address("a", "a", "a", null), phoneNumber1, Role.CUSTOMER)));
        assertTrue(exception.getMessage().contains("Cannot create Address"));
    }


    @Test
    void createCustomer_givenPhoneNumberParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.createUser(new User("firstname1", "lastname1", email1, address1, new PhoneNumber("0123"), Role.CUSTOMER)));
        assertTrue(exception.getMessage().contains("Cannot create PhoneNumber"));
    }
}