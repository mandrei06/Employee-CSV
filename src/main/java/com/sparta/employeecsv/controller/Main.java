package com.sparta.employeecsv.controller;

import com.sparta.employeecsv.model.CSVExtract;
import com.sparta.employeecsv.model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = CSVExtract.readCSV("EmployeeRecords.csv");
        for (Employee employee : employees) {
            System.out.println(employee.getId()+" " + employee.getPrefix()+" "
                    + employee.getFirstName()+" " + employee.getMiddleInitial()+" "
                    + employee.getLastName()+" " + employee.isGender()+" "
                    + employee.getEmail()+" " + employee.getDateOfBirth()+" "
                    + employee.getDateOfJoining()+" " + employee.getSalary());
        }
    }
}
