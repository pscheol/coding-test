package com.coding.leetcode.dynamic;

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.climbStairs(5);
        System.out.println(result);
    }
    private static class Solution {
        public int climbStairs(int n) {
            int[] ref = new int[n + 1];
            ref[0] = ref[1] = 1;
            for (int i = 2; i <= n; i++) {
                ref[i] = ref[i-1] + ref[i-2];
            }
            return ref[n];
        }
    }
}
