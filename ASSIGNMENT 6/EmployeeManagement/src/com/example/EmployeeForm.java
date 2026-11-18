
package com.example;

import javax.swing.*;
import java.awt.*;

public class EmployeeForm extends JFrame {

    private JTextField empIdField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField salaryField;

    private JTable employeeTable;

    public EmployeeForm() {

        // Window settings
        setTitle("Employee Management System");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Heading
        JLabel heading = new JLabel(
            "Employee Management System",
            SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 22));

        mainPanel.add(heading, BorderLayout.NORTH);

        // Employee form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.setBorder(
            BorderFactory.createTitledBorder("Add New Employee")
        );

        empIdField = new JTextField();
        nameField = new JTextField();
        departmentField = new JTextField();
        salaryField = new JTextField();

        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(empIdField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Salary:"));
        formPanel.add(salaryField);

        // Buttons
        JButton submitButton = new JButton("Submit");

        JButton viewButton =
            new JButton("View All Employees");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(submitButton);
        buttonPanel.add(viewButton);

// Form and buttons
JPanel topPanel = new JPanel(new BorderLayout(10, 10));

topPanel.add(formPanel, BorderLayout.CENTER);
topPanel.add(buttonPanel, BorderLayout.SOUTH);

// Employee table
employeeTable = new JTable();

JScrollPane scrollPane =
    new JScrollPane(employeeTable);

scrollPane.setBorder(
    BorderFactory.createTitledBorder("Employee Records")
);

// Set preferred table size
scrollPane.setPreferredSize(new Dimension(700, 220));

// Create content panel
JPanel contentPanel = new JPanel(new BorderLayout(10, 10));

contentPanel.add(topPanel, BorderLayout.NORTH);
contentPanel.add(scrollPane, BorderLayout.CENTER);

// Add content to main panel
mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Submit button action
        submitButton.addActionListener(e -> addEmployee());

        // View button action
        viewButton.addActionListener(e -> viewEmployees());

        add(mainPanel);
    }

    // Add employee to database
    private void addEmployee() {

        try {

            int empId = Integer.parseInt(
                empIdField.getText().trim()
            );

            String name = nameField.getText().trim();

            String department =
                departmentField.getText().trim();

            double salary = Double.parseDouble(
                salaryField.getText().trim()
            );

            if (name.isEmpty() || department.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all employee details."
                );

                return;
            }

            if (salary < 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Salary cannot be negative."
                );
                return;
            }

            boolean success = EmployeeDAO.addEmployee(
                empId, name, department, salary
            );

            if (success) {

                JOptionPane.showMessageDialog(
                    this,
                    "Employee added successfully!"
                );

                clearFields();
                viewEmployees();

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Unable to add employee. Check the Employee ID."
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Employee ID must be an integer and salary must be numeric."
            );
        }
    }

    // Display all employees
    private void viewEmployees() {

        employeeTable.setModel(
            EmployeeDAO.getAllEmployees()
        );
    }

    // Clear form fields
    private void clearFields() {

        empIdField.setText("");
        nameField.setText("");
        departmentField.setText("");
        salaryField.setText("");
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            EmployeeForm form = new EmployeeForm();

            form.setVisible(true);
        });
    }
}
