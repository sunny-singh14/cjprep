package org.example.dynamic;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a position at which you want to know fibonacci sequence: ");
        int position = scanner.nextInt();
        if (position < 0)
            throw new IllegalArgumentException("Position must be a non-negative integer.");

        BigInteger result = computeFibonacciNumber(position);
        System.out.printf("Number in fibonacci sequence at position %s is: %s", position, result);
    }

    private static final Map<Integer, BigInteger> fibonacciMemo = new ConcurrentHashMap<>();

    private static BigInteger computeFibonacciNumber(int position) {
        if (fibonacciMemo.containsKey(position))
            return fibonacciMemo.get(position);

        if (position < 2)
            return BigInteger.valueOf(position);

        BigInteger result = computeFibonacciNumber(position - 1)
                .add(computeFibonacciNumber(position - 2));
        fibonacciMemo.put(position, result);
        return result;
    }
}
