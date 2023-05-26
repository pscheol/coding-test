package com.coding.programmers.level1;

public class 타일21 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
    }
    static class Solution {
        public long solution(int n) {
            long mod = 1000000007;
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % mod;
            }

            return dp[n];
        }
    }
}
