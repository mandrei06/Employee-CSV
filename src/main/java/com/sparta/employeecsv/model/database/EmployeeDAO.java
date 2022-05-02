package com.sparta.employeecsv.model.database;

import com.sparta.employeecsv.model.entities.Employee;

import java.sql.*;

public class EmployeeDAO {

    public static void createEmployee(Employee employee, Connection conn){
        String insertString = "INSERT INTO employees(EmployeeID,NamePrefix, FirstName,MiddleInitial, LastName,Gender, Email,DateOfBirth, DateOfJoining,salary) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertString);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Employee getEmployeeById(int employee_id, Connection conn){

        Statement statement;
        Employee result;
        try {
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery
                    ("SELECT * FROM employees WHERE EmployeeID=" + employee_id + ";");

            if (!rs.next()) return null;
            result=new Employee();
            result.setId(rs.getInt("EmployeeID"));
            result.setPrefix(rs.getString("NamePrefix"));
            result.setFirstName(rs.getString("FirstName"));
            result.setMiddleInitial(rs.getString("MiddleInitial"));
            result.setLastName(rs.getString("LastName"));
            result.setGender(rs.getString("Gender"));
            result.setEmail(rs.getString("Email"));
            result.setDateOfBirth(rs.getDate("DateOfBirth"));
            result.setDateOfJoining(rs.getDate("DateOfJoining"));
            result.setSalary(rs.getInt("salary"));
            //add for each field

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }


}
