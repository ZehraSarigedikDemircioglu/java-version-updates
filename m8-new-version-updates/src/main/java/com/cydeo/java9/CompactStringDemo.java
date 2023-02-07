package com.cydeo.java9;


public class CompactStringDemo {

    public static void main(String[] args) {

        String abc = "cydeo";

    }
}

/*
Strings in Java are internally represented by a char[] containing the characters
of the String, and every char is made up of 2 bytes because Java internally uses
UTF-16

Strings typically usually occupy a large proportion of the JVM heap space.
Because of the way they are stored by the JVM, in most cases, a String instance
can take double space it actually needs

Whenever we create a String if all the characters of the String can be
represented using a byte ,LATIN-1 representation, a byte array will be used
internally. In other cases, if any character requires more than 8-bits to represent
it, all the characters are stored using two bytes for each, UTF-16 representation.
 */
