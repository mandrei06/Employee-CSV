package com.sparta.employeecsv.model.validation;

import java.util.regex.Pattern;

public class ValidateEmail {

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return VALID_EMAIL_ADDRESS_REGEX.matcher(s).find();
    }
}
