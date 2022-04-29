package com.sparta.employeecsv.model.threading;

import com.sparta.employeecsv.model.database.DBDriver;
import com.sparta.employeecsv.model.entities.Employee;

import java.util.HashMap;

public class ThreadFactory implements Runnable {
    private final HashMap<Integer, Employee> halfArray=new HashMap<>();

    public ThreadFactory(HashMap<Integer, Employee> employees, int start, int stop) {
        int i=0;
        for(Integer id : employees.keySet()){
            if(i==start && start<stop-1){
                halfArray.put(id,employees.get(id));
                start++;
            }
            i++;
        }
    }

    public void method() {
        DBDriver.databaseWriter(halfArray);
    }


    @Override
    public void run() {

        method();
    }
}
