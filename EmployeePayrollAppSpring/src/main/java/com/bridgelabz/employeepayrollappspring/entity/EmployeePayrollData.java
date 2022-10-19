package com.bridgelabz.employeepayrollappspring.entity;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
public @Data class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    private String gender;

    private Date startDate;

    private String note;

    private String profilePic;

    private List<String> department;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = empId;
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
        this.gender = employeePayrollDTO.getGender();
        this.startDate = employeePayrollDTO.getStartDate();
        this.note = employeePayrollDTO.getNote();
        this.profilePic = employeePayrollDTO.getProfilePic();
        this.department = employeePayrollDTO.getDepartment();
    }
}