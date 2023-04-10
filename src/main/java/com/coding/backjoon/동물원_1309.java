package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dp[n][0]= n번줄에 배치하지 않음 (dp[n][0], dp[n][1], dp[n][2])
 * dp[n][1]= n번줄의 왼쪽에 배치  (dp[n][0]. dp[n][2])
 * dp[n][2]= n번줄의 오른쪽에 배치* * (dp[n][0], dp[n][1])
 * dp[n][0] = dp[n-1][0] + dp[n-1][1] + dp[n-1][2]
 * dp[n][1] = dp[n-1][0] + dp[n-1][2]
 * dp[n][2] = dp[n-1][0] + dp[n-1][1]
 */
public class 동물원_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 9901;
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
        }

        System.out.println(((dp[n][0] + dp[n][1] + dp[n][2]) % mod));
    }
}
