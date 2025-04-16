package coder.shy.leetcode;

import java.util.Arrays;

public class SortColors75 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1,0,1,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (nums.length < 2)
            return;

        int low = 0, pointer = 0;
        int high = nums.length - 1;
        while (pointer <= high) {
            if (nums[pointer] == 0) {
                swap(nums, low, pointer);
                low++;
                pointer++;
            } else if (nums[pointer] == 2) {
                swap(nums, pointer, high);
                high--;
            } else
                pointer++;
        }
    }

    private static void swap(int[] values, int left, int right) {
        if (left == right)
            return;
        values[left] = values[left] - values[right];
        values[right] = values[left] + values[right];
        values[left] = values[right] - values[left];
    }
}
