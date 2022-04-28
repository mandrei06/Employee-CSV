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
            //                                              1           2           3       4               5       6       7       8           9            10
            String insertString = "INSERT INTO employees(EmployeeID,NamePrefix, FirstName,MiddleInitial, LastName,Gender, Email,DateOfBirth, DateOfJoining,salary) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertString);


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
                preparedStatement.setInt(1, employee.getId());
                preparedStatement.setString(2, employee.getPrefix());
                preparedStatement.setString(3, employee.getFirstName());
                preparedStatement.setString(4, employee.getMiddleInitial());
                preparedStatement.setString(5, employee.getLastName());
                preparedStatement.setString(6, employee.getGender());
                preparedStatement.setString(7, employee.getEmail());
                preparedStatement.setDate(8, employee.getDateOfBirth());
                preparedStatement.setDate(9, employee.getDateOfJoining());
                preparedStatement.setInt(10, employee.getSalary());
                preparedStatement.executeUpdate();
                System.out.println(row++);

//              statement.executeUpdate("INSERT INTO employees(EmployeeID,\n" +
//                        "NamePrefix, FirstName,\n" +
//                        "MiddleInitial, LastName,\n" +
//                        "Gender, Email,\n" +
//                        "DateOfBirth, DateOfJoining,\n" +
//                        "salary\n" +
//                        ") VALUES("+employee.getId()+",'" + employee.getPrefix()+"','"
//                        + employee.getFirstName()+"','" + employee.getMiddleInitial()+"','"
//                        + employee.getLastName()+"','" + employee.isGender()+"','"
//                        + employee.getEmail()+"','" + employee.getDateOfBirth()+"','"
//                        + employee.getDateOfJoining()+"'," + employee.getSalary()+");");
            }


            statement.close();
            preparedStatement.close();

            ConnectionFactory.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
