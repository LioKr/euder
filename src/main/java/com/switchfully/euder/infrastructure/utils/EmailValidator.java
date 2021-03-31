package com.switchfully.euder.infrastructure.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public final class EmailValidator {
    private static final String EMAIL_VALID_FORMAT = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final Pattern EMAIL_VALID_PATTERN = Pattern.compile(EMAIL_VALID_FORMAT, Pattern.CASE_INSENSITIVE);
    /*private static UserDb userDb; //Question is this ok? it works but feels bad

    @Autowired
    public EmailValidator(UserDb userDb) {
        this.userDb = userDb;
    }

     */

    public static boolean isValidEmail(String email) {
        return EMAIL_VALID_PATTERN.matcher(email).matches();
/*        return (EMAIL_VALID_PATTERN.matcher(email).matches()
                && isNewEmail(email)
        );

 */
    }
/*
    private static boolean isNewEmail(String email) {
        return userDb.getAllUser().stream()
                .map(User::getEmail)
                .map(Email::getMailAddress)
                .noneMatch(mailAddress -> mailAddress.toLowerCase().equals(email.toLowerCase()));
    }

 */
}
