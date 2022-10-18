package com.bridgelabz.employeepayrollappspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppSpringApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll App");
        SpringApplication.run(EmployeePayrollAppSpringApplication.class, args);
        System.out.println("SUCCESSFULLY CONNECTED");
    }

}
