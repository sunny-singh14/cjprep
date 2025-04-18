package coder.shy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum2461 {

    public static void main(String[] args) {
        System.out.println(maximumSubArraySum(new int[]{1, 9, 5, 4, 5, 4, 2, 9, 9, 9}, 3));
    }

    public static long maximumSubArraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        long currentSum = 0;
        long maxSum = 0;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            right++;
        }

        return maxSum;
    }
}
