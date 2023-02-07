package com.cydeo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {

    public static void main(String[] args) {

        double amount1 = 374.56;
        double amount2 = 374.26;
        System.out.println(amount1 - amount2); // 0.30000000000001137

        System.out.println("-------------------------------------------------");

        BigDecimal b1 = new BigDecimal("374.56");
        BigDecimal b2 = new BigDecimal("374.26");
        BigDecimal b3 = BigDecimal.valueOf(374.56);
        BigDecimal b4 = BigDecimal.TEN;
        BigDecimal b5 = BigDecimal.ONE;

        System.out.println(b1.subtract(b2)); // 0.30
        System.out.println(b1.add(BigDecimal.TEN)); // 384.56
        System.out.println(b1.multiply(new BigDecimal("15.00"))); // 5618.4000
        System.out.println(b1.multiply(BigDecimal.valueOf(15.56))); // 5828.1536

        //Scaling
        BigDecimal number1 = new BigDecimal("23.12");
        System.out.println(number1.setScale(1, RoundingMode.CEILING)); // 23.2
        System.out.println(number1.setScale(1, RoundingMode.FLOOR)); // 23.1
        System.out.println(number1.setScale(2, RoundingMode.FLOOR)); // 23.12
        System.out.println(number1.setScale(2, RoundingMode.CEILING)); // 23.12

        //Do not use equals(). Use compareTo()
        System.out.println(new BigDecimal("2").compareTo(new BigDecimal("2"))); // 0
        System.out.println(new BigDecimal("3").compareTo(new BigDecimal("2"))); // 1
        System.out.println(new BigDecimal("1").compareTo(new BigDecimal("2"))); // -1

    }
}

class Employee{
    private String name;
    private BigDecimal salary; // will use in the application
    // private double salary
}
