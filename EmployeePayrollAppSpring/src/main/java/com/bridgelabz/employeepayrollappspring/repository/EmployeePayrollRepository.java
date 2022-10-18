package com.bridgelabz.employeepayrollappspring.repository;

import com.bridgelabz.employeepayrollappspring.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
