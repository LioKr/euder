package com.switchfully.euder.service;

import com.switchfully.euder.domain.database.CustomerDb;
import com.switchfully.euder.domain.entities.customer.Address;
import com.switchfully.euder.domain.entities.customer.Customer;
import com.switchfully.euder.domain.entities.customer.Email;
import com.switchfully.euder.domain.entities.customer.PhoneNumber;
import com.switchfully.euder.domain.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerServiceTest {
    private CustomerService customerService;
    private Email email1;
    private PhoneNumber phoneNumber1;
    private Address address1;
    private Customer customer1;
    private UUID id1;

    @BeforeEach
    void init() {
        this.customerService = new CustomerService(new CustomerRepository(new CustomerDb()));
        this.email1 = new Email("some1@exemple.com");
        this.phoneNumber1 = new PhoneNumber("0032456000001");
        this.address1 = new Address("street1", "1", "1000", "city1");
        this.customer1 = new Customer("firstname1", "lastname1", email1, address1, phoneNumber1);
        this.id1 = customer1.getId();
    }

    @Test
    void createCustomer_givenCorrectParameter_thenReturnNewCustomer() {
        Customer actualResult = customerService.createCustomer(customer1);
        assertThat(actualResult.getId() == id1);
    }

    @Test
    void createCustomer_givenNullParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customerService.createCustomer(new Customer(null, "lastname1", email1, address1, phoneNumber1)));
        assertTrue(exception.getMessage().contains("Cannot create Customer"));
    }

    @Test
    void createCustomer_givenInvalidMailParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customerService.createCustomer(new Customer("firstname1", "lastname1", new Email("invalidMail"), address1, phoneNumber1)));
        assertTrue(exception.getMessage().contains("Cannot create Email"));
    }

    @Test
    void createCustomer_givenInvalidAddressParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customerService.createCustomer(new Customer("firstname1", "lastname1", email1, new Address("a", "a", "a", null), phoneNumber1)));
        assertTrue(exception.getMessage().contains("Cannot create Address"));
    }


    @Test
    void createCustomer_givenPhoneNumberParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customerService.createCustomer(new Customer("firstname1", "lastname1", email1, address1, new PhoneNumber("0123"))));
        assertTrue(exception.getMessage().contains("Cannot create PhoneNumber"));
    }
}