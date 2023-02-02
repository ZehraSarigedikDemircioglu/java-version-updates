package com.cydeo;

import com.cydeo.task.DishData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4,5,3,9);

        /*

        int sum = 0;
        for(int each : numbers){
            sum = sum + each;
        }

         */

        int result = numbers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(result);

        int total = DishData.getAll().stream().map(dish -> dish.getCalories()).reduce(0, (dish1, dish2) -> dish1 + dish2);
        System.out.println(total); // direct result using initial => 4200

        int totalCal = DishData.getAll().stream().map(dish -> dish.getCalories()).reduce((dish1, dish2) -> dish1 + dish2).get();
        System.out.println(totalCal); // direct result => 4200

        //Optional<Integer> totalCal2 = DishData.getAll().stream().map(dish -> dish.getCalories()).reduce((dish1, dish2) -> dish1 + dish2);
        Optional<Integer> totalCal2 = DishData.getAll().stream().map(dish -> dish.getCalories()).reduce(Integer::sum);
        System.out.println(totalCal2); // optional result => Optional[4200]

        // Max and Min
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        System.out.println("min = " + min.get()); // min = 3
        System.out.println("max = " + max.get());
        System.out.println("sum = " + sum.get());

        // Count
        long dishCount = DishData.getAll().stream().count();
        System.out.println(dishCount);
    }
}
