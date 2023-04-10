package com.coding.backjoon;

import java.util.Scanner;

public class 내림차순자릿수정렬_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nStr = scanner.next();
        char[] n = nStr.toCharArray();
        int[] a = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            a[i] = Integer.parseInt(String.valueOf(n[i]));
        }

        for (int i = 0; i < a.length; i++) {
            int max = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[max] < a[j]) {
                    max = j;
                }
            }
            int tmp = a[i];
            a[i] = a[max];
            a[max] = tmp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
