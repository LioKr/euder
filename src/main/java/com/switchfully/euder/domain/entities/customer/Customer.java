package com.switchfully.euder.domain.entities.customer;

import java.util.UUID;

public class Customer {
    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final Email email;
    private final Address address;
    private final PhoneNumber phoneNumber;

    public Customer(String firstname, String lastname, Email email, Address address, PhoneNumber phoneNumber) {
        if (!isValidCustomer(firstname, lastname, email, address, phoneNumber)) {
            throw new IllegalArgumentException("Cannot create Customer, illegal argument provided.");
        }
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidCustomer(String firstname, String lastname, Email email, Address address, PhoneNumber phoneNumber) {
        return firstname != null
                && lastname != null
                && email != null
                && address != null
                && phoneNumber != null;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
