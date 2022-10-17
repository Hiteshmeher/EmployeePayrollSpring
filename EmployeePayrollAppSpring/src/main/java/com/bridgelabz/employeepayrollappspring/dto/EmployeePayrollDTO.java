package com.bridgelabz.employeepayrollappspring.dto;

public class EmployeePayrollDTO {
    public String name;
    public long salary;

    // Constructors
    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    // toString method
    @Override
    public String toString() {
        return "name = " + name + " salary = " + salary;
    }
}
