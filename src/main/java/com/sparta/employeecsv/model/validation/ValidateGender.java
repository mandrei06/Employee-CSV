package com.sparta.employeecsv.model.validation;

import java.util.Objects;

public class ValidateGender {
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        return !s.equals("M") && !s.equals("F");
    }
}
