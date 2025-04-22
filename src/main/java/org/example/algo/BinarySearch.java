package org.example.algo;

import java.util.List;

public class BinarySearch {
    private static List<Integer> numbers;
    private static int number;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 0; i <= 10; i++) {
            int result = search(numbers, i);
            if (result != numbers.indexOf(i)) {
                System.out.println("ERROR : i=" + i);
            } else {
                System.out.println("FOUND " + i + " @ " + result);
            }
        }
    }

    public static int search(List<Integer> data, int key) {
        numbers = data;
        number = key;
        return search(0, numbers.size() - 1);
    }

    public static int search(int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        int currentValue = numbers.get(mid);
        if (number == currentValue)
            return mid;
        if (number < currentValue)
            return search(low, mid - 1);
        else
            return search(mid + 1, high);
    }
}
