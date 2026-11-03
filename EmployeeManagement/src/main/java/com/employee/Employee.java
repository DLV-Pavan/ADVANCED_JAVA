
package com.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Value("${employee.id}")
    private int employeeId;

    @Value("${employee.name}")
    private String employeeName;

    @Value("${employee.salary}")
    private double employeeSalary;

    @Value("${employee.department}")
    private String departmentName;

    public void display() {

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Salary: " + employeeSalary);
        System.out.println("Department: " + departmentName);
    }
}
