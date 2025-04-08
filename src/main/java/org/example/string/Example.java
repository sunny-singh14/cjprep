package org.example.string;

public class Example {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = s1 + s2;
        String s4 = "HelloHello";

        System.out.println(s3 == s4);  // true or false?
    }

}
