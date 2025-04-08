package org.example.algo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortData {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length == 0)
            args = readData();
        List<Integer> numbers = Arrays.stream(args).map(Integer::parseInt).toList();
        System.out.println(QuickSort.sort(numbers));
    }

    private static String[] readData() {
        System.out.print("Enter number: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("No data provided");
            System.exit(1);
        }
        return input.split(" ");
    }
}
