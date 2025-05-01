package coder.shy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubArray2799 {
    public static void main(String[] args) {
        System.out.println(new CountCompleteSubArray2799().countCompleteSubarrays(new int[]{5, 5, 5, 5}));
    }

    public int countCompleteSubarrays2(int[] nums) {
        int distinctElementCount = (int) Arrays.stream(nums).distinct().count();
        int distinctArrayCount = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> subArray = new HashSet<>();
            subArray.add(nums[i]);
            if (subArray.size() == distinctElementCount)
                distinctArrayCount++;
            for (int j = i + 1; j < nums.length; j++) {
                subArray.add(nums[j]);
                if (subArray.size() == distinctElementCount)
                    distinctArrayCount++;
            }
        }
        return distinctArrayCount;
    }

    public int countCompleteSubarrays(int[] nums) {
        int distinctElementCount = countDistinctElements(nums);
        int distinctArrayCount = 0;
        Set<Integer> subArray = HashSet.newHashSet(distinctElementCount);
        for (int i = 0; i < nums.length; i++) {
            subArray.add(nums[i]);
            if (subArray.size() == distinctElementCount)
                distinctArrayCount++;
            for (int j = i + 1; j < nums.length; j++) {
                subArray.add(nums[j]);
                if (subArray.size() == distinctElementCount)
                    distinctArrayCount++;
            }
            subArray.clear();
        }
        return distinctArrayCount;
    }

    private int countDistinctElements(int[] nums) {
        Set<Integer> counter = HashSet.newHashSet(nums.length);
        int sum = 0;
        for (int num : nums) {
            if (counter.add(num))
                sum++;
        }
        return sum;
    }

    private int countDistinctElements2(int[] nums) {
        int[] counter = new int[2001];
        for (int num : nums) {
            counter[num]++;
        }
        int sum = 0;
        for (int count : counter) {
            if (count != 0)
                sum++;
        }
        return sum;
    }
}
