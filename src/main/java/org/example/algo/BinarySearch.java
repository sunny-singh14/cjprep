package org.example.algo;

import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 9));
    }

    private static List<Integer> numbers;
    private static int number;

    public static int search(List<Integer> data, int key) {
        numbers = data;
        number = key;
        return search(0, numbers.size());
    }

    public static int search(int low, int high) {
        int midIndex = (low + high) / 2;
        int mid = numbers.get(midIndex);
        if (number == mid)
            return midIndex;
        if (number < mid)
            return search(low, midIndex);
        else
            return search(midIndex, high);
    }
}
