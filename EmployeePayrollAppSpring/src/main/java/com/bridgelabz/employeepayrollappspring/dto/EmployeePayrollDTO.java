package com.bridgelabz.employeepayrollappspring.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name should not be Null")
    private String name;
    @Min(value = 500,message = "Minimum Wage should be 500 or More")
    private long salary;

    private String gender;

    private Date startDate;

    private String note;

    private String profilePic;

    private List<String> department;


}