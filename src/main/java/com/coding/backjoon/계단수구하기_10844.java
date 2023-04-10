package com.coding.backjoon;

/**
 * dp[i][h] : 길이가 N인 계단에서 H 높이로 종료되는 계단 수를 만들 수 있는 경우의 수*
 * dp[i][0] = dp[i-1][0+1]
 * dp[i][9] = dp[i-1][9-1]
 * dp[i][h] = dp[i-1][h-1] + dp[i-1][h+1] h: 1~8
 */
public class 계단수구하기_10844 {
    public static void main(String[] args) {
        System.out.println(solution(2));
    }
    public static long solution(int n) {
        long[][] dp = new long[n+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][9];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
            }
        }

        long result = 0;
        for (int i = 0; i < dp[n].length; i++) {

            result = (result+ dp[n][i]) %  1000000000;;
        }


        return result;
    }
}
