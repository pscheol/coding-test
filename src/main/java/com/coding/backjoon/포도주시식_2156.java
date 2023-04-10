package com.coding.backjoon;

import java.util.Scanner;

public class 포도주시식_2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            a[i] = x;
        }
        System.out.println(solution(a,n));

    }
    public static int solution(int[] a, int n) {
        int[] dp = new int[n+1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + a[i-1] + a[i-2], dp[i-2]+ a[i]));
        }
        return dp[n];
    }
}
