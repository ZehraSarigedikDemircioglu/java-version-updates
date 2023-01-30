package com.cydeo.tasks;

import java.util.Arrays;
import java.util.List;

public class CountTest {

    public static void main(String[] args) {

        List<Integer> ci = Arrays.asList(1, 2, 3, 4);
        int countOdd = countIf(ci, new OddPredicate());
        int countPrime = countIf(ci, new PrimePredicate());
        System.out.println("Number of odd integers = " + countOdd);
        System.out.println("Number of prime integers = " + countPrime);

    }

    private static <T> int countIf(List<T> c, UnaryPredicate<T> p){

        int count = 0;
        for(T elem : c){
            if(p.test(elem)){
                ++count;
            }
        }
        return count;
    }


}
