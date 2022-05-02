package com.sparta.employeecsv.controller;

import com.sparta.employeecsv.model.commands.CSVExtract;
import com.sparta.employeecsv.model.database.DBDriver;
import com.sparta.employeecsv.model.database.TableFactory;
import com.sparta.employeecsv.model.entities.Employee;
import com.sparta.employeecsv.model.threading.ThreadDriver;
import com.sparta.employeecsv.model.validation.ValidateDate;
import com.sparta.employeecsv.view.EmployeeDisplay;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Employee> employees = CSVExtract.readCSV("EmployeeRecords.csv");

        double fastestTime = 100;
        int fastestThreads = 0;
        long startTime, endTime;
        // Employee List
        EmployeeDisplay.employeesDisplay(employees);

        // Employee Duplicate List
        //EmployeeDisplay.employeesDisplay(CSVExtract.duplicates);

        // Employee Corrupted Records List
        //EmployeeDisplay.employeesDisplay(CSVExtract.corruptedData);

        TableFactory.createTable();

        int[] noThreads = {2};
        for (int threads : noThreads){
            startTime = System.nanoTime();

            ThreadDriver.threadLauncher(employees, threads);

            endTime = System.nanoTime();

/*            if (fastestTime > (endTime - startTime)/1000000000.0) {
                fastestTime = (endTime - startTime)/1000000000.0;
                fastestThreads = threads;
            }*/

            System.out.println("Threads = " + threads + ", Done in " + (endTime - startTime)/1000000000.0 + " seconds");

        }
//        System.out.println("No threads = " + fastestThreads + " has fastest time = " + fastestTime);

      

    }
}
