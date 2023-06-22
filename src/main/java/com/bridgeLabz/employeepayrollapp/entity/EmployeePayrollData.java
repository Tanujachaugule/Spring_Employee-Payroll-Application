package com.bridgeLabz.employeepayrollapp.entity;

import com.bridgeLabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(){}

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO){
     this.employeeId=empId;
     this.name=employeePayrollDTO.name;
     this.salary=employeePayrollDTO.salary;
    }


}
