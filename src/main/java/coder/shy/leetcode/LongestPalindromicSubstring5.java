package coder.shy.leetcode;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeV2("bba"));
    }

    public static String longestPalindromeV2(String s) {
        if (s.length() < 2)
            return s;

        String largestPalindrome = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String oddPal = expandFromCenter(s, i, i);
            String evenPal = expandFromCenter(s, i, i + 1);
            if (oddPal.length() > largestPalindrome.length())
                largestPalindrome = oddPal;
            if (evenPal.length() > largestPalindrome.length())
                largestPalindrome = evenPal;
        }
        return largestPalindrome;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
