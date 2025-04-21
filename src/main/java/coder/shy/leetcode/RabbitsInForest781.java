package coder.shy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest781 {
    /**
     * [24,24,24,24,2,2,1,2,8,8,2,8,8]
     * [2,1,0,0,0,0,0]
     * [5,1,5,3,5,2,12,4,20,20]
     * [905, 401, 378, 983, 160, 183, 438, 585, 118, 90, 405, 120, 642, 812, 364, 903, 223, 350, 982, 752, 111, 996, 536, 701, 791, 202, 341, 891, 335, 477]
     * [33,25,22,2,39,15,50,7,5,12,12,12,12,3,4]
     * 2, 1, 2, 2, 2, 2, 2, 2, 1, 1
     * 0,3,2,0,3,3,4,2,4,3,2,4,4,3,0,1,3,4,4,3
     */

    public static void main(String[] args) {
        System.out.println(new RabbitsInForest781().numRabbits(new int[]{1, 1, 2}));
    }

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> colorGroup = new HashMap<>();

        for (int answer : answers) {
            colorGroup.compute(answer, (k, v) -> colorGroup.getOrDefault(k, 0) + 1);
        }

        System.out.println(colorGroup);

        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : colorGroup.entrySet()) {
            int groupSize = entry.getKey() + 1;
            int count = entry.getValue();
            int groups = (int) Math.ceil((double) count / groupSize);
            totalRabbits += groups * groupSize;
        }
        return totalRabbits;
    }

    public int numRabbitsV2(int[] answers) {
        // Step 1: Count frequency
        int[] freq = new int[1001]; // Constraints: answers[i] <= 1000
        for (int ans : answers) {
            freq[ans]++;
        }

        int total = 0;
        for (int x = 0; x < freq.length; x++) {
            if (freq[x] == 0) continue;

            int groupSize = x + 1;
            int count = freq[x];

            // equivalent to Math.ceil(count / groupSize) * groupSize
            int groups = (count + groupSize - 1) / groupSize;
            total += groups * groupSize;
        }
        return total;
    }

}
