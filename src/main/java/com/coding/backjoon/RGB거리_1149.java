package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB거리_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n+1][3];
        int a[][] = new int[n+1][3];

        for (int i = 1 ; i <= n; i ++) {
            String[] an = br.readLine().split(" ");
            for (int i1 = 0; i1 < an.length; i1++) {
                a[i][i1] = Integer.parseInt(an[i1]);
            }
        }


        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
