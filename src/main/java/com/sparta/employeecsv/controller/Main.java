package com.sparta.employeecsv.controller;

import com.sparta.employeecsv.model.CSVExtract;
import com.sparta.employeecsv.model.Employee;
import com.sparta.employeecsv.view.EmployeeDisplay;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Employee> employees = CSVExtract.readCSV("EmployeeRecords.csv");

        // Employee List
        EmployeeDisplay.employeesDisplay(employees, employees);

        // Employee Duplicate List
        EmployeeDisplay.employeesDisplay(CSVExtract.duplicates, employees);
    }


}
