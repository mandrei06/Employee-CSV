package com.sparta.employeecsv.model.commands;

import java.util.regex.Pattern;

public class EmailValidate {
    public static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValid(String s) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(s).find();
    }
}
