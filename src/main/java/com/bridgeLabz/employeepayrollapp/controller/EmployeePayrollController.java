package com.bridgeLabz.employeepayrollapp.controller;

import com.bridgeLabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgeLabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgeLabz.employeepayrollapp.entity.EmployeePayrollData;
import com.bridgeLabz.employeepayrollapp.service.EmployeePayrollService;
import com.bridgeLabz.employeepayrollapp.service.IEmployeePayrollService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful",empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully",empData);
        return  new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(employeePayrollDTO);;
        ResponseDTO resDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",empData);
        return  new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully","Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}
