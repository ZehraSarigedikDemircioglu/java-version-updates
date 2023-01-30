package com.cydeo;

import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

public class CarTest {

    public static void main(String[] args) {

        //Zero Argument Constructor
        Supplier<Car> c1 = () -> new Car();
        System.out.println(c1.get().getModel());

        Supplier<Car> c2 = Car::new;
        System.out.println(c2.get().getModel()); // 0 as default since did not create any obj
        System.out.println(c2.get().getMake()); // null as default since did not create any obj

        //One Argument Constructor
        Function<Integer, Car> c3 = model -> new Car(model);
        Function<Integer, Car> c4 = Car::new;
        System.out.println(c3.apply(5));
        System.out.println(c4.apply(7));

        //Two Argument Constructor
        BiFunction<String, Integer, Car> c5 = (make, model) -> new Car(make, model);
        BiFunction<String, Integer, Car> c6 = Car::new;
        System.out.println(c5.apply("model1", 2015));
        System.out.println(c6.apply("model2", 2018));

    }
}
