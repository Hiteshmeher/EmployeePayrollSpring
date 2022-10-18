package com.bridgelabz.employeepayrollappspring.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Salary should be more than 500")
    public long salary;

}