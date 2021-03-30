package com.switchfully.euder.domain.entities.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Email {
    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";
    private final String mailAddress;


    @JsonCreator
    public Email(@JsonProperty("mailAddress") String mailAddress) {
        if (!mailAddress.matches(EMAIL_FORMAT)) {
            throw new IllegalArgumentException("Cannot create Email, invalid format provided");
        }
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }
}
