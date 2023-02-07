package com.cydeo.java12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TeeingDemo {

    public static void main(String[] args) {

        // It is a new static method teeing to java.util.stream.Collectors interface which allows to collect
        // using two independent collectors, then merge their results using the supplied BiFunction

        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"A",100),
                new Employee(2,"B",200),
                new Employee(3,"C",300),
                new Employee(4,"D",400)
        );


        HashMap<String,Employee> result = employeeList.stream()
                .collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                Collectors.minBy(Comparator.comparing(Employee::getSalary)),
                (e1,e2) ->{
                    HashMap<String,Employee> map = new HashMap<>();
                    map.put("MAX",e1.get());
                    map.put("MIN",e2.get());
                    return map;
                }
        ));
        System.out.println(result);
    }
}
