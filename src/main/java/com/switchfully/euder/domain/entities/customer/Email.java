package com.switchfully.euder.domain.entities.customer;

public final class Email {
    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";
    private final String mailAddress;

    public Email(String mailAddress) {
        if(!mailAddress.matches(EMAIL_FORMAT)){
            throw new IllegalArgumentException("Cannot accept provided mail address, invalid format");
        }
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }
}
