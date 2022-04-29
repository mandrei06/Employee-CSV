package com.sparta.employeecsv.model.validation;

public class ValidateID {
        public static boolean isValid(String s) {
            if (s == null) {
                return false;
            }

            try {
                int ID = Integer.parseInt(s);
                if(ID < 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }



            return true;
        }
}
