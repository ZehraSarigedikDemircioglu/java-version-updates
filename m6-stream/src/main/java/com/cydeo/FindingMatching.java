package com.cydeo;

import com.cydeo.task.Dish;
import com.cydeo.task.DishData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class FindingMatching {

    public static void main(String[] args) {

        // ALL MATCH
        System.out.println("All Match");
        boolean isHealthy = DishData.getAll().stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        // ANY MATCH
        System.out.println("Any Match");
        boolean isHealthy2 = DishData.getAll().stream().anyMatch(dish -> dish.getCalories() == 1000);
        System.out.println(isHealthy2);
        if(DishData.getAll().stream().anyMatch(dish -> dish.isVegetarian())){
            System.out.println("The menu is vegetarian friendly");
        };

        // NONE MATCH
        System.out.println("None Match");
        boolean isHealthy3 = DishData.getAll().stream().noneMatch(dish -> dish.getCalories() == 1000);
        System.out.println(isHealthy3);

        // FIND ANY
        System.out.println("Find Any");
        Optional<Dish> result = DishData.getAll().stream().filter(dish -> dish.isVegetarian()).findAny();
        System.out.println(result); // Optional[Dish(name=fries, vegetarian=true, calories=530, type=OTHER)]
        System.out.println(result.get()); // Dish(name=fries, vegetarian=true, calories=530, type=OTHER)

        // FIND FIRST
        System.out.println("Find First");
        Optional<Dish> result2 = DishData.getAll().stream().filter(dish -> dish.isVegetarian()).findFirst();
        System.out.println(result2); // Optional[Dish(name=fries, vegetarian=true, calories=530, type=OTHER)]
        System.out.println(result2.get()); // Dish(name=fries, vegetarian=true, calories=530, type=OTHER)

        // PARALLEL STREAMS (Async)
        System.out.println(IntStream.range(0, 100).parallel().findAny()); // OptionalInt[65] async random
        System.out.println(IntStream.range(0, 100).parallel().findFirst()); // OptionalInt[0] always first one

        List<String> list1 = Arrays.asList("Jhonny","David","Jack","Duke","Jill","Dany","Julia","Jenish","Divya");
        List<String> list2 = Arrays.asList("Jhonny","David","Jack","Duke","Jill","Dany","Julia","Jenish","Divya");

        Optional<String> findFirst = list1.stream().parallel().filter(s -> s.startsWith("D")).findFirst();
        Optional<String> findAny = list2.stream().parallel().filter(s -> s.startsWith("J")).findAny();

        System.out.println(findFirst); // Optional[David]
        System.out.println(findFirst.get()); // David
        System.out.println(findAny); // Optional[Jill]

        Optional<String> findFirst2 = list1.stream().filter(s -> s.startsWith("D")).findFirst();
        Optional<String> findAny2 = list2.stream().filter(s -> s.startsWith("J")).findAny();

        System.out.println(findFirst2); // Optional[David]
        System.out.println(findFirst2.get()); // David
        System.out.println(findAny2); // Optional[Jhonny]

        // MIN and MAX
        Optional<Dish> min = DishData.getAll().stream().min(Comparator.comparing(dish -> dish.getCalories()));
        Optional<Dish> max = DishData.getAll().stream().max(Comparator.comparing(dish -> dish.getCalories()));
        System.out.println(min);
        System.out.println(max);

    }
}
