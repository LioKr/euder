package com.switchfully.euder.domain.entities.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.euder.infrastructure.utils.PhoneNumberValidator;

public final class PhoneNumber {
    private final String phoneNumber;

    @JsonCreator
    public PhoneNumber(@JsonProperty("phoneNumber") String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber))
            throw new IllegalArgumentException("Cannot create PhoneNumber, invalid format");
        this.phoneNumber = phoneNumber;
    }//Question when i put my validation here it's not going to the ExceptionHandlerController


    static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return PhoneNumberValidator.isValidPhoneNumber(phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
