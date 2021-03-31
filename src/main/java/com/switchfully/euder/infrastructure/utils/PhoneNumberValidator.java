package com.switchfully.euder.infrastructure.utils;

import java.util.regex.Pattern;

public final class PhoneNumberValidator {

    private static final String PHONE_VALID_FORMAT = "^((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_VALID_FORMAT, phoneNumber);
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
