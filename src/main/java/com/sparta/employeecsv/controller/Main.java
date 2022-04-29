package com.sparta.employeecsv.controller;

import com.sparta.employeecsv.model.commands.CSVExtract;
import com.sparta.employeecsv.model.database.DBDriver;
import com.sparta.employeecsv.model.entities.Employee;
import com.sparta.employeecsv.model.validation.ValidateDate;
import com.sparta.employeecsv.view.EmployeeDisplay;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Employee> employees = CSVExtract.readCSV("EmployeeRecords.csv");

        // Employee List
        EmployeeDisplay.employeesDisplay(employees);

        // Employee Duplicate List
        //EmployeeDisplay.employeesDisplay(CSVExtract.duplicates);

        // Employee Corrupted Records List
        //EmployeeDisplay.employeesDisplay(CSVExtract.corruptedData);

        long startTime = System.nanoTime();
      
        // Insert employees data in our database
        long startTime = System.nanoTime();
        DBDriver.databaseWriter(employees);
        long endTime = System.nanoTime();
      
        System.out.println("Done in " + (endTime - startTime)/1000000000.0);
    }
}
