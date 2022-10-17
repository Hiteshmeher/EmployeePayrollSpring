package com.bridgelabz.employeepayrollappspring.controller;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappspring.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappspring.entity.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Hitesh", 55000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * Displaying Employee data by id using get method
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(2, new EmployeePayrollDTO("Swayam", 60000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empPayrollDTO
     * Creating employee data using Body by Post mapping
     */
    @PostMapping(path = "/create", consumes = {"application/json"})
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Data ", empPayrollDTO);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * @param empPayrollDTO
     * Updating employee data using path variable and request body by put method
     */
    @PutMapping(path = "/update/{empId}", consumes = {"application/json"})
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data : ", empPayrollDTO);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * Deleting employee data using path variable by delete method
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Employee Data ", empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}
