package org.example.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Search {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length == 0)
            args = readData();
        List<Integer> numbers = new ArrayList<>(Arrays.stream(args).map(Integer::parseInt).toList());
        Integer key = numbers.removeLast();
        System.out.println("number found at index " + BinarySearch.search(numbers, key));
    }

    private static String[] readData() {
        System.out.print("Enter number last number will be key: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("No data provided");
            System.exit(1);
        }
        return input.split(" ");
    }
}
