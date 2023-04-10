package com.coding.backjoon;

import java.util.Scanner;

/**
 * 5 3
 * 5 4 3 2 1
 * ---------
 * 5 9 12 14 15
 * N = 5
 * M = 3
 * 1 3 : 12
 * 2 4 : 9
 * 5 5 : 1
 * 합배열 : S[i] = S[i-1] + A[i]
 * 구간합 : S = S[j] - S[i-1]
 */
public class 구간합구하기4_11659 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] S = new int[N + 1];
        S[1] = S[1] + scan.nextInt();
        for (int i = 2; i <= N; i++) {
            S[i] = S[i-1] + scan.nextInt();
        }

        for (int seq = 0; seq < M; seq++) {
            int i = scan.nextInt();
            int j = scan.nextInt();
            int sum = S[j] - S[i-1];
            System.out.println(sum);
        }
    }
}
