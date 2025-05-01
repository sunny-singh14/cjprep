package coder.shy.leetcode;

public class CountLargestGroup1399 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new CountLargestGroup1399().countLargestGroup(384));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int countLargestGroup(int n) {
        int maxSize = 0;
        int maxSizeCount = 0;
        for (int j = 1; j <= n; j++) {
            int validNumberCount = 0;
            if (j < 10)
                validNumberCount++;
            for (int i = j + 9; i <= n; i++) {
                if (sumDigits(i) == j) {
                    validNumberCount++;
                }
            }
            if (validNumberCount > maxSize) {
                maxSize = validNumberCount;
                maxSizeCount = 1;
            } else if (validNumberCount == maxSize)
                maxSizeCount++;
            else
                break;
        }
        return maxSizeCount;
    }

    private int sumDigits(int n) {
        int sum;
        for (sum = 0; n > 0; sum += n % 10, n /= 10)
            ;
        return sum;
    }
}
