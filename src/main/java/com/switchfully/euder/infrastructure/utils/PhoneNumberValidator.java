package com.switchfully.euder.infrastructure.utils;

import com.switchfully.euder.domain.database.UserDb;
import com.switchfully.euder.domain.entities.user.PhoneNumber;
import com.switchfully.euder.domain.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

public final class PhoneNumberValidator {
    private static final String PHONE_VALID_FORMAT = "^((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";
    private static UserDb userDb; //Question is this ok? it works but feels bad

    @Autowired
    public PhoneNumberValidator(UserDb userDb) {
        this.userDb = userDb;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return (Pattern.matches(PHONE_VALID_FORMAT, phoneNumber)
                && isNewPhoneNumber(phoneNumber)
        );
    }

    private static boolean isNewPhoneNumber(String phoneNumberInput) {
        return userDb.getAllUser().stream()
                .map(User::getPhoneNumber)
                .map(PhoneNumber::getPhoneNumber)
                .noneMatch(phoneNumber -> phoneNumber.toLowerCase().equals(phoneNumberInput.toLowerCase()));
    }
}
