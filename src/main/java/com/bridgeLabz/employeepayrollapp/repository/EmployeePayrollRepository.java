package com.bridgeLabz.employeepayrollapp.repository;

import com.bridgeLabz.employeepayrollapp.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

}
