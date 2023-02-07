package com.cydeo.java13;

public class TextBlockDemo {

    public static void main(String[] args) {

        // TextBlocks makes how we want to put style/version

        var address = "7925 Jones Branch Drive \n " +
                "McLean,va 22102";
        System.out.println(address);

        System.out.println("------------------------------");

        var address2 = """
                7925 Jones Branch Dr
                McLean,VA 22102 
                """;
        System.out.println(address2);
    }
}
