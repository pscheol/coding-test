package com.coding.leetcode.dynamic;

public class MinCostClimbingStairs_746 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
        System.out.println(result);
    }
    private static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int top = cost.length;
            int[] ref = new int[top + 1];
            ref[0] = ref[1] = 0;

            for (int i = 2; i <= top; i++) {
                ref[i] = Math.min(ref[i-1] + cost[i-1], ref[i-2] + cost[i-2]);
            }
            return ref[top];
        }
    }
}
