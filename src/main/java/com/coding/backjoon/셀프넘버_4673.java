package com.coding.backjoon;

public class 셀프넘버_4673 {
    public static void main(String[] args) {
        int n = 216;
        boolean[] self = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = d(i);
            if (num <= n) {
                self[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!self[i]) {
                System.out.println(i);
            }
        }

    }

    public static int d(int num) {
        int result = num;
        while (num != 0) {
            result += (num % 10);
            num /= 10;

        }
        return result;
    }
}
