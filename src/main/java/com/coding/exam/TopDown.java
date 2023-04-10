package com.coding.exam;

import java.util.Scanner;

public class TopDown {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        for (int i = 0; i<= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        fibo(n);

        for (int i = 0 ; i < n; i++) {
            System.out.println(dp[i]);
        }
    }
    static int fibo(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibo(n-2) + fibo(n-1);
    }
}
