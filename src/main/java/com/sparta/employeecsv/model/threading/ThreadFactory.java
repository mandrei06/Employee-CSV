package com.sparta.employeecsv.model.threading;

import com.sparta.employeecsv.model.database.DBDriver;
import com.sparta.employeecsv.model.entities.Employee;

import java.util.HashMap;

public class ThreadFactory implements Runnable {
    private HashMap<Integer, Employee> employees;
    private int start;
    private int stop;
    public ThreadFactory(HashMap<Integer, Employee> employees, int start, int stop) {
        this.employees = employees;
        this.start = start;
        this.stop = stop;

    }

/*    public void method() {
        DBDriver.databaseWriter(employees, start, stop);
    }*/

    @Override
    public void run() {
        DBDriver.databaseWriter(employees, start, stop);;
//        System.out.println("Done ");

    }
}
