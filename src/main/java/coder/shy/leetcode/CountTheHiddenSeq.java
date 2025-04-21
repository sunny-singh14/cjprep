package coder.shy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountTheHiddenSeq {
    /**
     * [2, -2, 3, -3, 4, -4, 5, -5]
     * 0
     * 10
     * [1, -1, 2, -2, 3, -3, 4, -4, 5, -5]
     * -3
     * 7
     * [3, -2, 1, -3, 2, -1, 3, -3]
     * 1
     * 8
     * [1, 1, 1, 1, 1, -5]
     * 0
     * 5
     * [5, -4, 3, -2, 1, -1, -2, 2, -3, 3]
     * -2
     * 6
     * [1, 2, -1, -2, 3, -3, 4, -4, 5, -5]
     * 0
     * 10
     * [4, -4, 4, -4, 4, -4, 4, -4, 4]
     * -5
     * 5
     * [1, 2, 3, -6, 4, -4, 5, -5]
     * -3
     * 7
     */

    public static void main(String[] args) {
        System.out.println(new CountTheHiddenSeq().numberOfArraysV2(new int[]{1, -3, 4}, 1, 6));
        System.out.println(new CountTheHiddenSeq().numberOfArraysV2(new int[]{-40}, -46, 53));
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int numberOfArrays = 0;
        for (int j = lower + 1; j < upper; j++) {
            List<Integer> elements = new ArrayList<>(differences.length + 1);
            elements.add(j);
            for (int i = 0; i < differences.length; i++) {
                int nextElement = elements.get(i) + differences[i];
                if (nextElement < lower || nextElement > upper)
                    break;
                elements.add(nextElement);
            }
            System.out.println(elements);
            if (elements.size() == differences.length + 1) {
                numberOfArrays++;
            }
        }
        System.out.println((upper - lower + 1) - (-6 - (-46)));
        return numberOfArrays;
    }

    public int numberOfArraysV2(int[] differences, int lower, int upper) {
        long min = lower + 1L;
        long max = lower + 1L;
        int prev = lower + 1;
        for (int difference : differences) {
            int nextElement = prev + difference;
            prev = nextElement;
            if (nextElement < min)
                min = nextElement;
            if (nextElement > max)
                max = nextElement;
        }
        long range = max - min;
        long numberOfArrays = (upper - lower + 1) - range;
        if (Integer.MAX_VALUE < numberOfArrays)
            numberOfArrays = 0;
        return (int) Math.max(numberOfArrays, 0);
    }

    public int numberOrArraysWorking(int[] differences, int lower, int upper) {
        List<Integer> elements = new ArrayList<>(differences.length + 1);
        elements.add(lower + 1);
        for (int i = 0; i < differences.length; i++) {
            int nextElement = elements.get(i) + differences[i];
            elements.add(nextElement);
        }
        long min = elements.getFirst();
        long max = elements.getLast();
        for (Integer element : elements) {
            if (element < min)
                min = element;
            if (element > max)
                max = element;
        }
        long range = max - min;
        long numberOfArrays = (upper - lower + 1) - range;
        if (Integer.MAX_VALUE < numberOfArrays)
            numberOfArrays = 0;
        return (int) Math.max(numberOfArrays, 0);
    }
}
