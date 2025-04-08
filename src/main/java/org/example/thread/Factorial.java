package org.example.thread;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factorial {
    public static void main(String[] args) {
        Set<Long> factorials = new TreeSet<>();
        long start = System.currentTimeMillis();
        try (ExecutorService executor = Executors.newFixedThreadPool(8)) {
            for (long i = 0; i < 200000; i++) {
                final long input = i;
                executor.submit(() -> factorial(input, factorials));
            }
        }
        factorials.forEach(System.out::println);
        System.out.printf("total time taken %s", System.currentTimeMillis() - start);
    }

    private static void factorial(long n, Set<Long> results) {
        long result = 1;
        for (long i = 1; i < n; i++) {
            result *= i;
        }
        results.add(result);
    }
}
