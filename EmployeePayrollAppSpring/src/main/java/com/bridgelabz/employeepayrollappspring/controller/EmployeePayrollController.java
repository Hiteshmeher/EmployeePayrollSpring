package com.bridgelabz.employeepayrollappspring.controller;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappspring.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappspring.entity.EmployeePayrollData;
import com.bridgelabz.employeepayrollappspring.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     *
     * @return all list of Employee Payroll Data
     */
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * Employee Data by id as Path Variable using Get Mapping
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData empPayrollData = null;
        empPayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successfull", empPayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empPayrollDTO
     * Creating Employee data by Request Body using Post Mapping
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empPayrollDTO
     * Updating an Employee data by Path Variable and Request Body using Put Mapping
     */
    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO empPayrollDTO){

        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", empPayrollDTO);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * Detete an employee data by id as path variable using Delete Mapping
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " +empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
