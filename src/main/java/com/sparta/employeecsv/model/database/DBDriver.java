package com.sparta.employeecsv.model.database;

import com.sparta.employeecsv.model.entities.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBDriver {
    public static void databaseWriter(HashMap<Integer, Employee> employees) {
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

            for (Integer id : employees.keySet()){
                Employee employee= employees.get(id);
                statement.executeUpdate("INSERT INTO employees(EmployeeID,\n" +
                        "NamePrefix, FirstName,\n" +
                        "MiddleInitial, LastName,\n" +
                        "Gender, Email,\n" +
                        "DateOfBirth, DateOfJoining,\n" +
                        "salary\n" +
                        ") VALUES("+employee.getId()+",'" + employee.getPrefix()+"','"
                        + employee.getFirstName()+"','" + employee.getMiddleInitial()+"','"
                        + employee.getLastName()+"','" + employee.isGender()+"','"
                        + employee.getEmail()+"','" + employee.getDateOfBirth()+"','"
                        + employee.getDateOfJoining()+"'," + employee.getSalary()+");");
            }


            statement.close();

            ConnectionFactory.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
