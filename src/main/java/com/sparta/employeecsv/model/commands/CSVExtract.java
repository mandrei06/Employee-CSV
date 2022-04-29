package com.sparta.employeecsv.model.commands;

import com.sparta.employeecsv.model.entities.Employee;
import com.sparta.employeecsv.model.validation.ValidateDate;
import com.sparta.employeecsv.model.validation.ValidateEmail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVExtract {
    public static HashMap<Integer, Employee> duplicates = new HashMap<>();
    public static HashMap<Integer, Employee> corruptedData = new HashMap<>();

    public static HashMap<Integer, Employee> readCSV(String fileName) {
        HashMap<Integer, Employee> employeeList = new HashMap<>();
        List<String> lines;
        lines = getLines(fileName);
        for (String line : lines) {
            String[] words = line.split(",");
            Employee employee = new Employee();
            boolean corrupted = false;
            if (words.length == 10) {
                employee.setId(Integer.parseInt(words[0]));
                employee.setPrefix(words[1]);
                employee.setFirstName(words[2]);
                //Check for middleInitial
                if (words[3].length() == 1) {

                    employee.setMiddleInitial(words[3]);
                }
                employee.setLastName(words[4]);
                if (words[5].length() == 1) {
                    employee.setGender(words[5]);
                } else {
                    corrupted=true;
                }

                if (ValidateEmail.isValid(words[6])) {
                    employee.setEmail(words[6]);
                } else {
                    corrupted=true;
                }

                //Date Of Birth
                if (ValidateDate.isValid(words[7])) {
                    String[] dateOfBirth = words[7].split("/");
                    // year-month-day
                    String reformatDateOfBirth = dateOfBirth[2] + "-" + dateOfBirth[0] + "-" + dateOfBirth[1];
                    try {
                        employee.setDateOfBirth(Date.valueOf(reformatDateOfBirth));
                    } catch (IllegalArgumentException e) {
                        corrupted = true;
                    }
                } else {
                    corrupted = true;
                }

                //Date Of Joining
                if (ValidateDate.isValid(words[8])) {
                    String[] dateOfJoining = words[8].split("/");
                    String reformatDateOfJoining = dateOfJoining[2] + "-" + dateOfJoining[0] + "-" + dateOfJoining[1];
                    try {
                        employee.setDateOfJoining(Date.valueOf(reformatDateOfJoining));
                    } catch (IllegalArgumentException e) {
                        corrupted = true;
                    }
                } else {
                    corrupted = true;
                }

                employee.setSalary(Integer.parseInt(words[9]));

                //check for duplicates
                if (employeeList.containsKey(Integer.valueOf(words[0]))) {
                    duplicates.put(Integer.valueOf(words[0]), employee);
                } else if (corrupted) {
                    corruptedData.put(Integer.valueOf(words[0]), employee);
                } else {
                    employeeList.put(Integer.valueOf(words[0]), employee);
                }
            }else
            {
                corruptedData.put(Integer.valueOf(words[0]),new Employee());
            }
        }

        return employeeList;

    }

    public static List<String> getLines(String fileName) {
        List<String> result = null;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            result = new ArrayList<>();
            //discard the heading line
            br.readLine();
            //loop over all remaining lines
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
