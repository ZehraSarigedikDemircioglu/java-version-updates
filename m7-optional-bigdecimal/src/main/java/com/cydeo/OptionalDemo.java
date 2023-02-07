package com.cydeo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(2, 4, 2, 10, 23);

        // empty() - isPresent() => boolean
        Optional<String> empty = Optional.empty();
        System.out.println(empty); // Optional.empty
        System.out.println(empty.isPresent()); // false

        System.out.println(Optional.of(number).isPresent()); // true

        // System.out.println(empty.get()); // from get() method the result => NoSuchElementException

        // ifPresent
        Optional<Integer> bigNumber = number.stream().filter(x -> x > 100).findAny();
        bigNumber.ifPresent(System.out::println); // no result, nothing, but it did not throw exception

        // get
        // System.out.println(bigNumber.get()); // NoSuchElementException

        // orElse
        System.out.println(bigNumber.orElse(5)); // if no result, it will not give any exception. The default value will be 5 then.


        // Optional prevents nullPointerException
    }
}