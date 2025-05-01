package org.example.collection;

import java.util.List;

public class LastWord {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "mango", "banana", "avocado", "orange");

        String fruit = fruits
                .stream()
                .filter(f -> f.startsWith("g"))
                .reduce((_, f2) -> f2)
                .orElse("Not found");

        System.out.println(fruit);
    }
}
