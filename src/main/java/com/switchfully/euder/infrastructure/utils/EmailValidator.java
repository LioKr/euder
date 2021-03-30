package com.switchfully.euder.infrastructure.utils;

import java.util.regex.Pattern;

public final class EmailValidator {
    private static final String EMAIL_VALID_FORMAT = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final Pattern EMAIL_VALID_PATTERN = Pattern.compile(EMAIL_VALID_FORMAT, Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        return EMAIL_VALID_PATTERN.matcher(email).matches();
    }
}
