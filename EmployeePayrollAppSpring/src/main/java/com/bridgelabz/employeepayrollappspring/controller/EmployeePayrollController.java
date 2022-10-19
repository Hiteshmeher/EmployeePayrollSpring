package com.bridgelabz.employeepayrollappspring.controller;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappspring.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappspring.entity.EmployeePayrollData;
import com.bridgelabz.employeepayrollappspring.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    /**
     * Created the Variables template and counter to use globally.
     */
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     *
     * Getting all employee data
     */

    @GetMapping(value = {"", "/", "/getAll"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Getting employee details by id
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empPayrollData = null;
        empPayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successfull", empPayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * Creating an Employee Data
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * Updating an Employee Details
     */
    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {

        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     *Deleting an Employee Deatils
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}