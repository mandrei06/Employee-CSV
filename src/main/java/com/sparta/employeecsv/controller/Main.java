package com.sparta.employeecsv.controller;

import com.sparta.employeecsv.model.commands.CSVExtract;
import com.sparta.employeecsv.model.entities.Employee;
import com.sparta.employeecsv.model.threading.ThreadDriver;
import com.sparta.employeecsv.view.EmployeeDisplay;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Employee> employees = CSVExtract.readCSV("EmployeeRecords.csv");

        // Employee List
        EmployeeDisplay.employeesDisplay(employees);

        // Employee Duplicate List
        EmployeeDisplay.employeesDisplay(CSVExtract.duplicates);

        // Employee Corrupted Records List
        EmployeeDisplay.employeesDisplay(CSVExtract.corruptedData);


        // Insert employees data in our database
        long startTime = System.nanoTime();

        ThreadDriver.threadLauncher(employees);

        //DBDriver.databaseWriter(employees);
        long endTime = System.nanoTime();
      
        System.out.println("Done in " + (endTime - startTime)/1000000000.0);
    }
}
