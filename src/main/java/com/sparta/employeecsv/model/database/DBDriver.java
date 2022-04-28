package com.sparta.employeecsv.model.database;

import com.sparta.employeecsv.model.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBDriver {
    public static void databaseWriter(HashMap<Integer, Employee> employees) {
        int row = 0;
        try{
            Connection conn= ConnectionFactory.getConnection();

            Statement statement = conn.createStatement();




            statement.executeUpdate("DROP TABLE IF EXISTS employees;");
            statement.executeUpdate("""
                    CREATE TABLE Employees (
                        EmployeeID int,
                        NamePrefix varchar(255),
                        FirstName varchar(255),
                        MiddleInitial varchar(255),
                        LastName varchar(255),
                        Gender varchar(255),
                        Email varchar(255),
                        DateOfBirth date,
                        DateOfJoining date,
                        salary int
                    );""");

            PreparedStatement pStatement=conn.prepareStatement("INSERT INTO employees(EmployeeID,NamePrefix, " +
                            "FirstName,MiddleInitial, LastName,Gender, Email, DateOfBirth, DateOfJoining, salary) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)");
            for (Integer id : employees.keySet()){
                Employee employee= employees.get(id);
                pStatement.setInt(1,employee.getId());
                pStatement.setString(2,employee.getPrefix());
                pStatement.setString(3,employee.getFirstName());
                pStatement.setString(4, String.valueOf(employee.getMiddleInitial()));
                pStatement.setString(5,employee.getLastName());
                pStatement.setString(6, String.valueOf(employee.isGender()));
                pStatement.setString(7,employee.getEmail());
                pStatement.setDate(8,employee.getDateOfBirth());
                pStatement.setDate(9,employee.getDateOfJoining());
                pStatement.setInt(10,employee.getSalary());
                pStatement.executeUpdate();
                System.out.println(row++);
            }


            statement.close();

            ConnectionFactory.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
