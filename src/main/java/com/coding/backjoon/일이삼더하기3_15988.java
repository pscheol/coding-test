package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기3_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
        }
        int dp[] = new int [5];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4 ; i <= 4; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }
        System.out.println(dp[4] );
    }
}
