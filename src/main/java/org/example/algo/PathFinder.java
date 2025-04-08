package org.example.algo;

import java.util.Scanner;

public class PathFinder {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String from = readFrom();
        final String to = readTo();

        WeightedPathFinder pathFinder = new WeightedPathFinder(WeightedPathFinder.getSampleData(), from, to);
        pathFinder.findPath();
    }

    private static String readFrom() {
        System.out.print("From: ");
        String from = scanner.nextLine();
        if (from.isEmpty()) {
            System.out.println("Origin can't be empty");
            System.exit(1);
        }
        return from.toUpperCase();
    }

    private static String readTo() {
        System.out.print("To: ");
        String to = scanner.nextLine();
        if (to.isEmpty()) {
            System.out.println("Destination can't be empty");
            System.exit(1);
        }
        return to.toUpperCase();
    }
}
