package com.bridgelabz.employeepayrollappspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollAppSpringApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll App");
        SpringApplication.run(EmployeePayrollAppSpringApplication.class, args);
        System.out.println("SUCCESSFULLY CONNECTED");
    }

}
