package com.cydeo.task;

import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {

        // Print all emails
        System.out.println("Print All Emails");
        EmployeeData.readAll()
                .map(employee -> employee.getEmployeeEmail())
               // .map(Employee::getEmployeeEmail)
                .forEach(System.out::println);

        // Print all phone numbers
        System.out.println("Print All Phone Numbers");
        /*
        EmployeeData.readAll()
                .map(employee -> employee.getEmployeePhoneNumbers())
                .forEach(System.out::println);

         */

        EmployeeData.readAll()
                .flatMap(employee -> employee.getEmployeePhoneNumbers().stream())
                .forEach(System.out::println);

        System.out.println("Print All Phone Numbers with Double Colon");
        EmployeeData.readAll()
                .map(Employee::getEmployeePhoneNumbers)
                .flatMap(List::stream)
                .forEach(System.out::println);

    }
}
