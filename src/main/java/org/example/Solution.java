package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for(int i : nums) {
            int count = 0;
            if(counterMap.containsKey(i))
                count = counterMap.get(i);
            counterMap.put(i, ++count);
        }
        return counterMap.values().stream().max(Comparator.naturalOrder()).get();
    }
}