package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//10
//10 -4 3 1 5 6 -35 12 21 -1

/**
 * D[i] = Max(D[i-1] + A[i], A[i]);
 */
public class 연속합_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        System.out.println(solution(a));
    }
    public static int solution(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i-1] + a[i] , a[i]);

        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
