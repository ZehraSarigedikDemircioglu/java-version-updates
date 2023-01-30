package com.cydeo;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(10, 0, 15, 5, 20));

        //Ascending
        Collections.sort(list);
        System.out.println(list);

        //Descending
        Collections.sort(list, new MyComparator());
        System.out.println(list);

        Collections.sort(list, (o1, o2) -> (o1 > o2) ? -1 : (o2 > o1) ? 1 : 0);
        System.out.println(list);

        System.out.println("-----------------------------------------");

        //Ascending
        list.sort((o1, o2)-> o1.compareTo(o2)); // no need to call Collections
        System.out.println(list);

        //Descending
        list.sort((o2, o1) -> o1.compareTo(o2)); // since Comparator interface is ready, use functional interface lambda
        System.out.println(list);








    }
}
