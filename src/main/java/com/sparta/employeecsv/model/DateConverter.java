package com.sparta.employeecsv.model;

import java.sql.Date;

public class DateConverter {
    public Date getDate(String s) {
        String[] date = s.split("/");
        String reformatDate = date[2] + "-" + date[0] + "-" + date[1];
        Date convertedDate = null;
        try {
            convertedDate = Date.valueOf(reformatDate);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return convertedDate;
    }
}
