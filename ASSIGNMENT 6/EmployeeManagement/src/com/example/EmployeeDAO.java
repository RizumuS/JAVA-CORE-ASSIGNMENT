
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class EmployeeDAO {

    private static final String URL =
        "jdbc:mysql://localhost:3306/company_db";

    private static final String USER = "root";

    private static final String PASSWORD = "palakshi";

    // Establish database connection
    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
            URL, USER, PASSWORD
        );
    }

    // Insert a new employee
    public static boolean addEmployee(
            int empId, String name,
            String department, double salary) {

        String sql = "INSERT INTO employees " +
                     "(emp_id, name, department, salary) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Insert Error: "
                               + e.getMessage());
            return false;
        }
    }

    // Retrieve all employee records
    public static DefaultTableModel getAllEmployees() {

        DefaultTableModel model = new DefaultTableModel(
            new String[]{
                "Employee ID",
                "Name",
                "Department",
                "Salary"
            }, 0
        );

        String sql = "SELECT * FROM employees";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Object[] row = {
                    rs.getInt("emp_id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                };

                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println("Fetch Error: "
                               + e.getMessage());
        }

        return model;
    }
}
