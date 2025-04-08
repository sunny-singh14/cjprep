package org.example.calculation;

import java.math.BigInteger;
import java.util.Scanner;

public class Exponent {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter base: ");
        BigInteger base = BigInteger.valueOf(scanner.nextLong());
        System.out.print("Enter exponent: ");
        int expo = scanner.nextInt();
        if (expo < 0)
            throw new ArithmeticException("exponent can't be -ve");
        System.out.println(computeExpo(base, expo));
    }

    private static BigInteger computeExpo(BigInteger base, int expo) {
        if (expo == 0)
            return BigInteger.ONE;

        if (expo == 1)
            return base;

        if (expo % 2 == 0) {
            BigInteger halfPow = computeExpo(base, expo / 2);
            return halfPow.multiply(halfPow);
        } else
            return base.multiply(computeExpo(base, expo - 1));
    }
}
