package coder.shy.leetcode;

public class MaxProductPair {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 4, 2, 6, 7, 4, 8, -8, -7};
        approach1(numbers);
        approach2(numbers);
    }

    private static void approach2(int[] numbers) {
        if (numbers.length < 2)
            return;
        if (numbers.length == 2)
            System.out.printf("a = %d, b = %s", numbers[0], numbers[1]);

        int posa = Integer.MIN_VALUE;
        int posb = Integer.MAX_VALUE;

        int nega = Integer.MIN_VALUE;
        int negb = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > posa) {
                posb = posa;
                posa = number;
            } else if (number > posb) {
                posb = number;
            }

            if (number < 0 && (Math.abs(number) > Math.abs(nega))) {
                negb = nega;
                nega = number;
            } else if (number < 0 && (Math.abs(number) > Math.abs(negb))) {
                negb = number;
            }
        }

        if ((posa * posb) >= (nega * negb))
            System.out.printf("a = %d, b = %s", posa, posb);
        else
            System.out.printf("a = %d, b = %s", nega, negb);
    }

    private static void approach1(int[] numbers) {
        if (numbers.length < 2)
            return;
        int a = numbers[0];
        int b = numbers[1];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] * numbers[j] > a * b) {
                    a = numbers[i];
                    b = numbers[j];
                }
            }
        }
        System.out.printf("a = %d, b = %s%n", a, b);
    }
}
