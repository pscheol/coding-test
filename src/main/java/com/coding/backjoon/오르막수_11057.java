package com.coding.backjoon;

import java.util.Scanner;

public class 오르막수_11057 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] dp = new int[n+1][10 + 1];
        int mod = 10007;
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j=0; j<=9; j++) {
                for (int k = 0; k <=j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[n][i];
        }
        System.out.println(ans);
    }
}
