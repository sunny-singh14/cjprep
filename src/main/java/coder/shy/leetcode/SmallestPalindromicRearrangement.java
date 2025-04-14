package coder.shy.leetcode;

import java.util.Arrays;

public class SmallestPalindromicRearrangement {
    public static void main(String[] args) {
        System.out.println(smallestPalindromeV2("babbab"));
    }

    public static String smallestPalindrome(String s) {
        if (s.length() == 1)
            return s;

        int pivot = s.length() / 2;
        char[] firstHalf = s.substring(0, pivot).toCharArray();
        Arrays.sort(firstHalf);
        StringBuilder sb = new StringBuilder();
        for (char c : firstHalf) {
            sb.append(c);
        }
        if (s.length() % 2 != 0) {
            sb.append(s.charAt(pivot));
        }
        for (int i = firstHalf.length - 1; i >= 0; i--) {
            sb.append(firstHalf[i]);
        }
        return sb.toString();
    }

    public static String smallestPalindromeV2(String s) {
        int n = s.length();
        if (n == 1) return s;

        int half = n / 2;
        int[] freq = new int[26];
        for (int i = 0; i < half; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                sb.append((char) ('a' + i));
            }
        }

        if (n % 2 != 0) {
            sb.append(s.charAt(half));
        }

        // Append reverse of first half
        for (int i = sb.length() - (n % 2 == 0 ? 0 : 1) - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }

        return sb.toString();
    }

}
