package coder.shy.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 1, 2, 8, 5, 3);
        System.out.println(sort(numbers));
    }

    private static List<Integer> sort(List<Integer> numbers) {
        System.out.println(numbers);
        int size = numbers.size();
        for (int i = 0; i < size - 1; i++) {
            int j = findSmallestElementIndex(i, numbers);
            Collections.swap(numbers, i, j);
            System.out.println(numbers);
        }
        return numbers;
    }

    private static int findSmallestElementIndex(int outerIndex, List<Integer> numbers) {
        int smallestIndex = outerIndex;
        for (int i = outerIndex + 1; i < numbers.size(); i++) {
            if(numbers.get(smallestIndex) > numbers.get(i))
                smallestIndex = i;
        }
        return smallestIndex;
    }
}
