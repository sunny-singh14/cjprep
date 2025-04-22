package coder.shy.leetcode;

public class NumberOfIdealArrays2338 {
    public static void main(String[] args) {
        System.out.println(new NumberOfIdealArrays2338().idealArrays(2,5));
    }

    public int idealArrays(int n, int maxValue) {

        int mod = 1000000007;
        int[][] memo = new int[n + 1][maxValue + 1];

        for (int i = 1; i <= maxValue; i++) {
            memo[1][i] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int value = 1; value <= maxValue; value++) {
                for (int k = value; k <= maxValue; k += value) {
                    memo[length][k] = (memo[length][k] + memo[length - 1][value]) % mod;
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= maxValue; i++) {
            result = (result + memo[n][i]) % mod;
        }

        return result;
    }
}
