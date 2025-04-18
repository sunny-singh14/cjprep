package coder.shy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";

        return getString(getPairs(countAndSay(n - 1)));
    }

    public static String getString(List<int[]> pairs) {
        StringBuilder sb = new StringBuilder();
        for (int[] pair : pairs) {
            sb.append(pair[1]).append(pair[0]);
        }
        return sb.toString();
    }

    public static List<int[]> getPairs(String s) {
        List<int[]> pairs = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char current = s.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == current) {
                count++;
                j++;
            }
            pairs.add(new int[]{Character.getNumericValue(current), count});
            i = j;
        }
        return pairs;
    }
}
