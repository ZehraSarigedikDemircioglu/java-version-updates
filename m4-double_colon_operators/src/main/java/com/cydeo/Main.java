package com.cydeo;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Predicate<Integer> pred = p -> p % 2 == 0 ? true: false;
        // p % 2 == 0 ? true: false; implementation for the abstract methods belongs to functional interface

        // static method
        Calculate sum = (x, y) -> System.out.println(x + y);
        Calculate c1 = (x, y) -> Calculator.findSum(x, y);
        Calculate c2 = Calculator::findSum;
        c2.calculate(10, 20); // checked if it is correct

        // instance method
        Calculate multiply = (x, y) -> System.out.println(x * y);
        Calculator obj = new Calculator();
        Calculate c3 = obj::findMultiply;
        Calculate c4 = new Calculator()::findMultiply;
        c3.calculate(3, 5); // 15
        c4.calculate(4, 6); // 24

        BiFunction<String, Integer, String> func1 = (str, i) -> str.substring(i);
        BiFunction<String, Integer, String> func2 = String::substring; // substring method refers to String class
        System.out.println(func1.apply("Wooden", 2)); // oden
        System.out.println(func2.apply("Spoon", 4)); // n

        Function<Integer, Double> b1 = new MyClass()::method;
        BiFunction<MyClass, Integer, Double> b2 = MyClass::method;
        System.out.println(b1.apply(3)); // 3*2.5 = 7.5
        System.out.println(b2.apply(new MyClass(), 2)); // 2.5*2 = 5.0

        Consumer<Integer> display = i -> System.out.println(i);
        Consumer<Integer> display2 = System.out::println;
        display.accept(3); // 3
        display2.accept(5); // 5







    }
}
