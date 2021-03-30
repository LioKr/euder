package com.switchfully.euder.domain.entities.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.euder.infrastructure.exceptions.InvalidMailException;
import com.switchfully.euder.infrastructure.utils.EmailValidator;

public final class Email {
    private final String mailAddress;

    @JsonCreator
    public Email(@JsonProperty("mailAddress") String mailAddress) {
        if (!EmailValidator.isValidEmail(mailAddress)) {
            throw new InvalidMailException("Cannot create Email: " + mailAddress + ", invalid format provided");
        }
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }
}
