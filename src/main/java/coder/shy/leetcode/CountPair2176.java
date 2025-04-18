package coder.shy.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class CountPair2176 {
    public static void main(String[] args) {
        long mapVer = 0;
        long loopVer = 0;
        long parallel = 0;
        for (int i = 0; i < 238; i++) {
            int[] nums = generateRandomArray(100, 9);
            long start = System.currentTimeMillis();
            countPairs(nums, 2);
            mapVer = mapVer + (System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            countPairsV1(nums, 2);
            loopVer = loopVer + (System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            countPairsV2(nums, 2);
            parallel = parallel + (System.currentTimeMillis() - start);
        }
        System.out.println("map version : " + mapVer);
        System.out.println("loop version : " + loopVer);
        System.out.println("parallel version : " + parallel);
    }

    public static int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            List<Integer> indices = map.getOrDefault(val, new ArrayList<>());

            for (int j : indices) {
                if ((i * j) % k == 0) {
                    count++;
                }
            }

            indices.add(i);
            map.put(val, indices);
        }

        return count;
    }

    public static int countPairsV1(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int countPairsV2(int[] nums, int k) {
        return IntStream.range(0, nums.length - 1).parallel()
                .map(i -> {
                    int count = 0;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] == nums[j] && (i * j) % k == 0) {
                            count++;
                        }
                    }
                    return count;
                }).sum();
    }

    private static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound); // values between 0 (inclusive) and bound (exclusive)
        }
        return array;
    }
}
