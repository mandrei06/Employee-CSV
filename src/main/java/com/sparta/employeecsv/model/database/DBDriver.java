package com.sparta.employeecsv.model.database;

import com.sparta.employeecsv.model.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBDriver {
    public static void databaseWriter(HashMap<Integer, Employee> employees,int start, int stop) {

        try{
            Connection conn= ConnectionFactory.getConnection();
            int rows = 0;
            Statement statement = conn.createStatement();
            //                                              1           2           3       4               5       6       7       8           9            10
            String insertString = "INSERT INTO employees(EmployeeID,NamePrefix, FirstName,MiddleInitial, LastName,Gender, Email,DateOfBirth, DateOfJoining,salary) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertString);

            for (int i = start; i < stop; i++) {
                Employee employee= employees.get(i);
                EmployeeDAO.createEmployee(employee, conn);
            }

            statement.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
