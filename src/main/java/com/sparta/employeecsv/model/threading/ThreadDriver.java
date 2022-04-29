package com.sparta.employeecsv.model.threading;

import com.sparta.employeecsv.model.database.ConnectionFactory;
import com.sparta.employeecsv.model.entities.Employee;

import java.util.HashMap;

public class ThreadDriver {
    public static void threadLauncher(HashMap<Integer, Employee> employees){
        ThreadFactory t1=new ThreadFactory(employees,0,employees.size()/2);
        ThreadFactory t2=new ThreadFactory(employees,employees.size()/2+1,employees.size()-1);
        Thread thread1= new Thread(t1);
        Thread thread2= new Thread(t2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //I close the connection here because if I close it in DBDDriver is possible that
        //one of the threads to finish first and to close the connection, in this way
        //the other thread cannot insert values in db anymore
        ConnectionFactory.closeConnection();

    }
}
