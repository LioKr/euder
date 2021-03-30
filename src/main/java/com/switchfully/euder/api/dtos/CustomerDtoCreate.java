package com.switchfully.euder.api.dtos;

import com.switchfully.euder.domain.entities.user.Address;
import com.switchfully.euder.domain.entities.user.Email;
import com.switchfully.euder.domain.entities.user.PhoneNumber;

public class CustomerDtoCreate {

    private String firstname;
    private String lastname;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;

    public CustomerDtoCreate setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CustomerDtoCreate setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CustomerDtoCreate setEmail(Email email) {
        this.email = email;
        return this;
    }

    public CustomerDtoCreate setAddress(Address address) {
        this.address = address;
        return this;
    }

    public CustomerDtoCreate setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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
