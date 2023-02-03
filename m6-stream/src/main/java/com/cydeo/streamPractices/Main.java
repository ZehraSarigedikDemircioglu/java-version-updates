package com.cydeo.streamPractices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        //1.1 Find all transactions in the year 2011 and sort them by value(small to high)
        transactions.stream()
                .filter(p -> p.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");

        //1.2 Find all transactions in the year 2011 and sort them by value(high to small)
        transactions.stream()
                .filter(p -> p.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");

        //2. What are all the unique cities where the traders work
        transactions.stream()
                .map(trader -> trader.getTrader())
                .map(city -> city.getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");

        //3. Find all traders from Cambridge and sort them by name
        transactions.stream()
                .map(trader -> trader.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");

        //4.1 Return a string of all traders’ names sorted alphabetically.
        String namesSorted = transactions.stream()
                .map(trader -> trader.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(namesSorted);

        System.out.println("------------------------------------------------");

        //4.2 Return an array of all traders’ names sorted alphabetically.
        Object[] objects = transactions.stream()
                .map(trader -> trader.getTrader().getName())
                .distinct()
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(objects));

        System.out.println("------------------------------------------------");

        //5. Are any traders based in Milan?
        boolean milan = transactions.stream()
                .anyMatch(trader -> trader.getTrader().getCity().equals("Milan"));
        System.out.println(milan);

        System.out.println("------------------------------------------------");

        //6. Print the values of all transactions from the traders living in Cambridge
        transactions.stream()
                .filter(trader -> trader.getTrader().getCity().equals("Cambridge"))
                .map(trader -> trader.getValue())
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");

        //7.1 What is the highest transaction?
        Optional<Transaction> max1 = transactions.stream()
                .max(Comparator.comparing(p -> p.getValue()));
        System.out.println(max1.get());

        System.out.println("------------------------------------------------");

        //7.2 What is the highest value of all the transactions?
        Optional<Integer> max2 = transactions.stream()
                .map(p -> p.getValue())
                .reduce(Integer::max);
        System.out.println(max2.get());

        System.out.println("------------------------------------------------");

        //8.1 What is the lowest transaction?
        Optional<Transaction> min1 = transactions.stream()
                .min(Comparator.comparing(p -> p.getValue()));
        System.out.println(min1.get());

        System.out.println("------------------------------------------------");

        //8.2 Find the transaction with the smallest value.
        Optional<Integer> min2 = transactions.stream()
                .map(p -> p.getValue())
                .reduce(Integer::min);
        System.out.println(min2.get());

    }
}

