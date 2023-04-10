package com.coding.exam;

import java.util.Scanner;

public class BottomUp {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        for (int i = 0 ; i <= n; i++) {
            System.out.println(dp[i]);
        }
    }
}
