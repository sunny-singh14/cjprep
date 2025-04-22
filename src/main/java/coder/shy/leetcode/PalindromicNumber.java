package coder.shy.leetcode;

public class PalindromicNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromicNumber().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int divisor = 1;
        while (x / divisor >= 10)
            divisor *= 10;

        while (x != 0) {
            int leading = x / divisor;
            int trailing = x % 10;
            if (leading != trailing)
                return false;
            x = (x % divisor) / 10;
            divisor = divisor / 100;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;

        if (x < 10)
            return true;

        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        return x == reverse;
    }
}
