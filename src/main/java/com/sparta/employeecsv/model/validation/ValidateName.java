package com.sparta.employeecsv.model.validation;

public class ValidateName {
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        return s.matches("^[a-zA-Z]{2,}");
    }
}
