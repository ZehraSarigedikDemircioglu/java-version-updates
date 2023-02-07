package com.cydeo.java11;

import java.util.ArrayList;
import java.util.List;

public class StringMethodDemo {

    public static void main(String[] args) {

        // lines() method is used to get all the lines in a String as a Stream.

        var str = "\n Mike \n Ozzy \n Tom \n Emmy";
        str.lines().forEach(System.out::println);

        System.out.println("---------------------------");

        String words = "Hi\nHello\nYes\r\nNo\n";

        List<String> lineExample = new ArrayList<>();
        words.lines().forEach(p -> lineExample.add(p));

        System.out.println(lineExample);

    }
}
