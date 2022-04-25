package com.sparta.employeecsv.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CSVExtract {
    public static List<Employee> readCSV(String fileName) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> lines;
        lines = getLines(fileName);
        for (String line : lines) {
            String[] words = line.split(",");
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(words[0]));
            employee.setPrefix(words[1]);
            employee.setFirstName(words[2]);
            //Check for middleInitial
            if (words[3].length() == 1) {
                char middleInitial = words[3].charAt(0);
                employee.setMiddleInitial(middleInitial);
            }
            employee.setLastName(words[4]);
            if (words[5].length() == 1)
                employee.setGender(words[5].charAt(0));

            if (EmailValidate.isValid(words[6])) {
                employee.setEmail(words[6]);
            }

            //Date Of Birth
            String[] dateOfBirth = words[7].split("/");
            String reformatDateOfBirth = dateOfBirth[2] + "-" + dateOfBirth[0] + "-" + dateOfBirth[1];
            employee.setDateOfBirth(Date.valueOf(reformatDateOfBirth));

            //Date Of Joining
            String[] dateOfJoining = words[8].split("/");
            String reformatDateOfJoining = dateOfJoining[2] + "-" + dateOfJoining[0] + "-" + dateOfJoining[1];
            employee.setDateOfJoining(Date.valueOf(reformatDateOfJoining));

            employee.setSalary(Float.parseFloat(words[9]));
            employeeList.add(employee);
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
//                String[] values = line.split(",");
//                System.out.print("[");
//                for (int i = 0; i < values.length; i++) {
//                        System.out.print(values[i] + ", ");
//                }
//                System.out.println("]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
