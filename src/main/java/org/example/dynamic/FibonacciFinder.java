package org.example.dynamic;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciFinder {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a position at which you want to know fibonacci sequence: ");
        int position = scanner.nextInt();
        if (position < 0)
            throw new IllegalArgumentException("Position must be a non-negative integer.");
        BigInteger result = numberInFibonacciAt(position);
        System.out.printf("Number in fibonacci sequence at position %s is: %s", position, result);
    }

    private static BigInteger numberInFibonacciAt(int position) {
        if (position < 2)
            return BigInteger.valueOf(position);

        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;

        for (int i = 2; i <= position; i++) {
            BigInteger next = first.add(second);
            first = second;
            second = next;
        }

        return second;
    }
}