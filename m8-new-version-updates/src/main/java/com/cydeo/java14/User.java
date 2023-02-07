package com.cydeo.java14;

public record User(String name, String address) {

    // As of JDK 14, we can replace our repetitious data classes with records. Records are
    // immutable data classes that require only the type and name of fields

    // All provided data(field) is private and final!!!!!!!!!!!


    //ALL ARG CONST
    //GETTER -> NO SETTER yet in the application!!!
    //TO STRING
    //EQUALS
    //HASH CODE
}
