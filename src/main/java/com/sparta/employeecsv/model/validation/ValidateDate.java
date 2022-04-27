package com.sparta.employeecsv.model.validation;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateDate{

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        System.out.println(s);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d = date.parse(s);
            System.out.println(d);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
