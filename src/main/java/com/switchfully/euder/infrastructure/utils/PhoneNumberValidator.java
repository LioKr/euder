package com.switchfully.euder.infrastructure.utils;

import java.util.regex.Pattern;

public final class PhoneNumberValidator {
    private static final String PHONE_VALID_FORMAT = "^((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";
    //private static UserService userService; //Question is this ok? it works but feels bad
/*
    @Autowired
    public PhoneNumberValidator(UserService userService) {
        this.userService = userService;
    }

 */

    public static boolean isValidPhoneNumber(String inputPhoneNumber) {
        return Pattern.matches(PHONE_VALID_FORMAT, inputPhoneNumber);
        /*return (Pattern.matches(PHONE_VALID_FORMAT, inputPhoneNumber)
                && isNewPhoneNumber(inputPhoneNumber));

         */
    }
/*
    private static boolean isNewPhoneNumber(String inputPhoneNumber) {
        return userService.getAllUser().stream()
                .map(User::getPhoneNumber)
                .map(PhoneNumber::getPhoneNumber)
                .noneMatch(phoneNumber -> phoneNumber.equals(inputPhoneNumber));
    }

 */
}


