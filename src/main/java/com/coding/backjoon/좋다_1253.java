package com.coding.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 좋다_1253 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int s = 0;
            int e = N - 1;
            int f = arr[i];
            while (s < e) {
                int sum = arr[s] + arr[e];
                if (sum > f) {
                    e--;
                } else if (sum < f) {
                    s++;
                } else { //sum == f equals
                    if (s != i && e != i) {
                        count++;
                        break;
                    } else if (s == i) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
