package com.coding.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽의명령_1940 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = scan.nextInt();
        }
        Arrays.sort(NUMS);

        int s = 0;
        int e = N-1;
        int count = 0;
        while (s < e) {
            int sum = NUMS[s] + NUMS[e];
            if (sum > M) {
                e--;
            } else if (sum < M) {
                s++;
            } else { //sum == M equals
                s++;
                e--;
                count++;
            }
        }
        System.out.println(count);
    }
}
