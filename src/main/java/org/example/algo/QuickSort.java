package org.example.algo;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(sort(List.of(4, 2, 2, 6, 1, 3)));
    }

    public static List<Integer> sort(List<Integer> numbers) {
        if (numbers.size() < 2)
            return numbers;

        int pivotIndex = numbers.size() / 2;
        int pivot = numbers.get(pivotIndex);

        List<Integer> lessThanOrEqualToPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i == pivotIndex) continue;
            int number = numbers.get(i);
            if (number <= pivot)
                lessThanOrEqualToPivot.add(number);
            else
                greaterThanPivot.add(number);
        }

        return mergeLists(sort(lessThanOrEqualToPivot), pivot, sort(greaterThanPivot));
    }

    private static List<Integer> mergeLists(List<Integer> left, Integer pivot, List<Integer> right) {
        List<Integer> mergedList = new ArrayList<>(left.size() + 1 + right.size());
        mergedList.addAll(left);
        mergedList.add(pivot);
        mergedList.addAll(right);
        return mergedList;
    }
}
