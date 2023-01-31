package com.cydeo.task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {

    private int employeeId;
    private String employeeName;

    private String employeeEmail;

    private List<String> employeePhoneNumbers; // each employee more than one number. For ex; 1) regular phone, 2) Emergency phone





}
