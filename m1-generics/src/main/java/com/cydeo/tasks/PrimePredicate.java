package com.cydeo.tasks;

public class PrimePredicate implements UnaryPredicate<Integer>{


    @Override
    public boolean test(Integer obj) {
        if(obj < 1){
            return false;
        }
        if(obj < 3){
            return false;
        }

        for (int i = 2; i < obj; i++) {
            if(obj % i == 0){
                return false;
            }
        }
        return true;
    }
}
