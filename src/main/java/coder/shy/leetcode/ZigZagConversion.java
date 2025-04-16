package coder.shy.leetcode;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1)
            return s;

        char[][] charGraph = new char[numRows][s.length()];

        int charPointer = 0;
        int diagonal = 0;
        for (int i = 0; charPointer < s.length(); i++) {
            if (diagonal == 0) {
                for (int j = 0; j < numRows && charPointer < s.length(); j++, charPointer++) {
                    charGraph[j][i] = s.charAt(charPointer);
                }
                diagonal = numRows - 2;
            } else {
                charGraph[diagonal][i] = s.charAt(charPointer);
                charPointer++;
                diagonal--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (charGraph[i][j] != '\u0000')
                    sb.append(charGraph[i][j]);
            }
        }
        return sb.toString();
    }
}
