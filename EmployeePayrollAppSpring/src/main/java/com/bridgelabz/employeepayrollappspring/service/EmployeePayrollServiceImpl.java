package com.bridgelabz.employeepayrollappspring.service;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappspring.entity.EmployeePayrollData;
import com.bridgelabz.employeepayrollappspring.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollappspring.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    /**
     * @return all employee List
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    /**
     * @param empId Getting employee details by id
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    /**
     * @param empPayrollDTO Creating an employee data
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    /**
     * @param empId
     * @param empPayrollDTO Updating employee data by using id
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
//      empData.setName(empPayrollDTO.getName());
//      empData.setSalary(empPayrollDTO.getSalary());
//      empData.setStartDate(empPayrollDTO.getStartDate());
//      empData.setGender(empPayrollDTO.getGender());
//      empData.setNote(empPayrollDTO.getNote());
//      empData.setProfilePic(empPayrollDTO.getProfilePic());
//      empData.setDepartment(empPayrollDTO.getDepartment());

        empData.updateEmployeeEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    /**
     * @param empId
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }
}