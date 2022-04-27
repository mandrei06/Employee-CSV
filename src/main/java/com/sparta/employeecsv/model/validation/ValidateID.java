package com.sparta.employeecsv.model.validation;

public class ValidateID {
        public boolean isValid(String s) {
            if (s.length() > 6) {
                return false;
            }

            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }

            return true;
        }
}
