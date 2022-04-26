package com.sparta.employeecsv.model.database;

import com.sparta.employeecsv.model.entities.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBDriver {
    public static void databaseWriter(HashMap<Integer, Employee> employees) {
        try{
            Connection conn= ConnectionFactory.getConnection();

            Statement statement = conn.createStatement();

//            ResultSet rs = statement.executeQuery("SELECT * FROM film_text");
//            while (rs.next()) {
//                System.out.println(rs.getString("description"));
//            }

            int rows_updated;
            statement.executeUpdate("DROP TABLE IF EXISTS employees;");
            rows_updated=statement.executeUpdate("CREATE TABLE Employees (\n" +
                    "    EmployeeID int,\n" +
                    "    NamePrefix varchar(255),\n" +
                    "    FirstName varchar(255),\n" +
                    "    MiddleInitial varchar(255),\n" +
                    "    LastName varchar(255),\n" +
                    "    Gender varchar(255),\n" +
                    "    Email varchar(255),\n" +
                    "    DateOfBirth date,\n" +
                    "    DateOfJoining date,\n" +
                    "    salary int\n" +
                    ");");

            for (Integer id : employees.keySet()){
                Employee employee= employees.get(id);
            }


            statement.close();

            ConnectionFactory.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
