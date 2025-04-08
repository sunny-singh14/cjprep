package coder.shy.algo;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int index = search(numbers, 7);
        if (index != -1)
            System.out.println("number found on index " + index);
        else
            System.out.println("number not found");
    }

    private static int search(List<Integer> data, int key) {
        int low = 0;
        int high = data.size() - 1;
        while (low <= high) {
            int midIndex = (low + high) / 2;
            int mid = data.get(midIndex);
            if (key == mid)
                return midIndex;
            if (key < mid)
                high = midIndex - 1;
            else
                low = midIndex + 1;
        }
        return -1;
    }
}
