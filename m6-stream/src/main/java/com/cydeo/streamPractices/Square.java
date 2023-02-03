package com.cydeo.streamPractices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Square {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> square = nums.stream().map(a -> a * a).collect(Collectors.toList());
        System.out.println(square);
    }
}
/*
Given a list of numbers how would you return a list of the square of each
number? For example, given [1,2,3,4,5] you should return [1,4,9,16,25]
 */
