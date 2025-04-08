package org.example.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdasExample {
    public static void main(String[] args) {
        var names = new ArrayList<>(List.of("Joe", "Susan", "John", "Louise"));

        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names);

    }
}
