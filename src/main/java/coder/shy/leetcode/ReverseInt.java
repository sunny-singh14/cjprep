package coder.shy.leetcode;

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
        //2147483647
        //9646324351
        //7498840704
    }

    public static int reverse(int x) {
        int reversed = 0;
        int prevRev = 0;
        while (x != 0) {
            int rem = x % 10;
            x = x / 10;
            reversed = (reversed * 10) + rem;
            if (prevRev == reversed / 10) {
                prevRev = reversed;
            } else {
                return 0;
            }
        }
        return reversed;
    }
}
