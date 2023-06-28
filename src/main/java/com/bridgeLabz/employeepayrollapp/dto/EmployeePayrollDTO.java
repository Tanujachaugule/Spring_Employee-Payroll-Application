package com.bridgeLabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> department;


}
