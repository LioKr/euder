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
    }

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

                    /*= "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" //US regex
                + "|^\+(?:[0-9]●?){6,14}[0-9]$" // validate international phone numbers
                + "|^\+[0-9]{1,3}\.[0-9]{4,14}(?:x.+)?$" // EPP format
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$"
                + "|^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$"  //france regex
                + "|^(?:(?:\\+|00)32|0)\\s*(?:[\\s.-]*\\d{2}){4}$" //belgium regex
                + "|^(?:(?:\\+|00)32|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$"; //belgium cellular regex

                 */
