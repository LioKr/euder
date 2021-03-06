package com.switchfully.euder.domain.entities.user;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final Email email;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final Role role;

    public User(String firstname, String lastname, Email email, Address address, PhoneNumber phoneNumber, Role role) {
        if (!isValidUser(firstname, lastname, email, address, phoneNumber, role)) {
            throw new IllegalArgumentException("Cannot create User, illegal argument provided.");
        }
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    private boolean isValidUser(String firstname, String lastname, Email email, Address address, PhoneNumber phoneNumber, Role role) {
        return firstname != null
                && lastname != null
                && email != null
                && address != null
                && phoneNumber != null
                && role != null;
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

    public Role getRole() {
        return role;
    }
}
