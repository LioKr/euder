package com.switchfully.euder.infrastructure.utils;

import java.util.regex.Pattern;

public final class PhoneNumberValidator {

    private static final String PHONE_VALID_FORMAT = "^((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_VALID_FORMAT, phoneNumber);
    }


}
