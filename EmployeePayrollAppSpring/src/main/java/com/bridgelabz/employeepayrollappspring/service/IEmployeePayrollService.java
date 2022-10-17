package com.bridgelabz.employeepayrollappspring.service;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappspring.entity.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
