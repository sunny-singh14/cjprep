package coder.shy.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        s = s.strip();
        boolean isNegative = false;
        char[] chars = s.toCharArray();
        long result = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (result == 0 && aChar == '-' && i == 0)
                isNegative = true;
            else if (Character.isDigit(aChar)) {
                result = (result * 10) + Character.digit(aChar, 10);
                if (result > Integer.MAX_VALUE) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else if (aChar != '+' || i > 0) {
                break;
            }
        }
        return isNegative ? -(int) result : (int) result;
    }

    public static int myAtoiV2(String s) {
        if (s == null || s.isEmpty()) return 0;

        int i = 0, len = s.length();
        while (i < len && s.charAt(i) == ' ') i++; // skip leading spaces

        if (i == len) return 0;

        boolean isNegative = false;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        long result = 0;
        while (i < len && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }

        return isNegative ? (int) -result : (int) result;
    }
}
