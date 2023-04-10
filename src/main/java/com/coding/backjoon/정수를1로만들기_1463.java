package com.coding.backjoon;

import java.util.Scanner;

/*
X=3  N/3
-1=2 N/2
X


D[i] : i에서 1로 가는데 최소 연산 횟수
D[i] = D[i-1] +1 //1빼는 연산
D[i] = min(D[i/2] + 1) 2로 나누는 연산
D[i] = min(D[i/3] + 1) 3로 나누는 연산
dp[i] = Math.min(dp[i/2] + (i%2), dp[i/3] + (i/3)) + 1
 */
public class 정수를1로만들기_1463 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <=n; i++) {
            dp[i] = Math.min(dp[i/2] + (i%2), dp[i/3] + (i/3)) + 1;
            System.out.println(dp[i]);
        }

        System.out.print(dp[n]);
    }
}
