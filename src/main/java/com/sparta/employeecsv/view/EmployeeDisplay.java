package com.sparta.employeecsv.view;

import com.sparta.employeecsv.model.Employee;

import java.util.HashMap;

public class EmployeeDisplay {

    public static void employeesDisplay(HashMap<Integer, Employee> employees, HashMap<Integer, Employee> employees1) {
        for (Integer id : employees.keySet()) {
            Employee employee= employees1.get(id);
            System.out.println(employee.getId()+" " + employee.getPrefix()+" "
                    + employee.getFirstName()+" " + employee.getMiddleInitial()+" "
                    + employee.getLastName()+" " + employee.isGender()+" "
                    + employee.getEmail()+" " + employee.getDateOfBirth()+" "
                    + employee.getDateOfJoining()+" " + employee.getSalary());
        }
    }

}
