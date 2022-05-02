package com.sparta.employeecsv.model.threading;

import com.sparta.employeecsv.model.database.ConnectionFactory;
import com.sparta.employeecsv.model.database.TableFactory;
import com.sparta.employeecsv.model.entities.Employee;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDriver {
    public static void threadLauncher(HashMap<Integer, Employee> employees, int noThreads) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(noThreads);

        TableFactory.createTable();

        for(int i = 0; i < noThreads; i++) {
            ThreadFactory myThread = new ThreadFactory(employees, i*employees.size()/noThreads, Math.min((i+1) * employees.size()/noThreads, employees.size()));
            executor.execute(myThread);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        ConnectionFactory.closeConnection();

    }
}
