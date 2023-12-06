package Calculaution;

import java.util.StringTokenizer;

public class Calculation implements ICalculation {

    @Override
    public int findMin(int arr[]) throws Exception {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null!");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("arr cannot be of length zero!");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int arr[]) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int cube(int n) {
        return n * n * n;
    }

    public static int square(int n) {
        return n * n * n;
    }

    public static String reverseWord(String str) {

        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        while (tokenizer.hasMoreTokens()) {
            StringBuilder sb = new StringBuilder();
            sb.append(tokenizer.nextToken());
            sb.reverse();

            result.append(sb);
            result.append(" ");
        }
        return result.toString();
    }
}
