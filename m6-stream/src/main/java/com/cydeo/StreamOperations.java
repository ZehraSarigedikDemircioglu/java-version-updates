package com.cydeo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 3, 4, 6);
        // list.forEach(System.out::println);

        //FILTER
        System.out.println("filter");
        list.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        //DISTINCT
        System.out.println("distinct");
        list.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // LIMIT(maxsize) = only get until maxsize values
        System.out.println("limit");
        list.stream()
                .filter(i -> i % 2 == 0)
                .limit(1)
                .forEach(System.out::println);

        // SKIP(n) = only get values except n or remove values from n
        System.out.println("skip");
        list.stream()
                .filter(i -> i % 2 == 0)
                .skip(1)
                .forEach(System.out::println);

        // MAP
        System.out.println("map");
        list.stream()
                .map(i -> i *10)
                .filter(i -> i % 3 == 0)
                .distinct()
                .forEach(System.out::println);

    }
}
