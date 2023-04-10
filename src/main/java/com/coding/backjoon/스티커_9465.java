package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int [2][n+1];
            for (int j = 0; j < 2; j++) {
                String[] nSplit = br.readLine().split(" ");
                for (int k = 1; k <= nSplit.length; k++) {
                 a[j][k] = Integer.parseInt(nSplit[k-1]);
                }
            }
            System.out.println(solution(a,n));
        }
    }
    public static int solution(int[][] a, int n) {
        int[][] dp = new int[2][n+1];

        dp[0][0] = dp[1][0] = 0;
        dp[1][1] = a[1][1];
        dp[0][1] = a[0][1];
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + a[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + a[1][i];
        }

        return Math.max(dp[0][n], dp[1][n]);
    }
}
