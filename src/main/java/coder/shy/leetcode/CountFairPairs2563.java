package coder.shy.leetcode;

import java.util.Arrays;

public class CountFairPairs2563 {

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long pairCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);

            if (left <= right) {
                pairCount += (right - left + 1);
            }
        }

        return pairCount;
    }

    private static int lowerBound(int[] nums, int low, int high, int target) {
        int res = high + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static int upperBound(int[] nums, int low, int high, int target) {
        int res = low - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

}
