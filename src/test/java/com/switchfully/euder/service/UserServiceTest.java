package com.switchfully.euder.service;

import com.switchfully.euder.domain.database.UserDb;
import com.switchfully.euder.domain.entities.user.*;
import com.switchfully.euder.domain.repositories.UserRepository;
import com.switchfully.euder.infrastructure.exceptions.InvalidMailException;
import com.switchfully.euder.infrastructure.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {
    private UserService userService;
    private Email email1;
    private PhoneNumber phoneNumber1;
    private Address address1;
    private User user1;
    private User user2;
    private UUID id1;

    @BeforeEach
    void init() {
        this.userService = new UserService(new UserRepository(new UserDb()));
        this.email1 = new Email("some1@exemple.com");
        this.phoneNumber1 = new PhoneNumber("0032456000001");
        this.address1 = new Address("street1", "1", "1000", "city1");
        this.user1 = new User("firstname1", "lastname1", email1, address1, phoneNumber1, Role.CUSTOMER);
        this.user2 = new User("firstname2", "lastname2", new Email("some2@mail.com"), address1, new PhoneNumber("0033456000002"), Role.CUSTOMER);
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

    @Test
    void getAllCustomer_givenCorrectParameter_thenReturnListOfAllCustomer() {
        //GIVEN
        userService.createUser(user1);
        userService.createUser(user2);
        //WHEN
        List<User> actualResult = userService.getAllCustomer();
        //THEN
        assertThat(List.of(user1, user2)).hasSameElementsAs(actualResult);
    }

    @Test
    void getOneCustomerById_givenCorrectParameter_thenReturnCustomer() {
        //GIVEN
        userService.createUser(user1);
        userService.createUser(user2);
        //WHEN
        User actualResult1 = userService.getOneCustomerById(user1.getId());
        User actualResult2 = userService.getOneCustomerById(user2.getId());
        //THEN
        assertThat(user1 == actualResult1);
        assertThat(user2 == actualResult2);
    }

    @Test
    void getOneCustomerById_givenNotExistingIdParameter_thenThrowUserNotFoundException() {
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> userService.getOneCustomerById(UUID.fromString("b37f75ca-220e-462a-8987-e7b8cacde591")));
        assertTrue(exception.getMessage().contains("Cannot find User with Id matching: " + "b37f75ca-220e-462a-8987-e7b8cacde591"));
    }

}