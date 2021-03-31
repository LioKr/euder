package com.switchfully.euder.api.dtos;

import com.switchfully.euder.domain.entities.user.Address;
import com.switchfully.euder.domain.entities.user.Email;
import com.switchfully.euder.domain.entities.user.PhoneNumber;

import java.util.UUID;

public class CustomerDto {
    private UUID id;
    private String firstname;
    private String lastname;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;

    public CustomerDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public CustomerDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CustomerDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CustomerDto setEmail(Email email) {
        this.email = email;
        return this;
    }

    public CustomerDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public CustomerDto setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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
