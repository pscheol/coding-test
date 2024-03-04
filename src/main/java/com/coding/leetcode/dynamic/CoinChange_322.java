package com.coding.leetcode.dynamic;

import java.util.Arrays;

public class CoinChange_322 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(result);
        System.out.println(sol.coinChange(new int[]{2}, 3));
        System.out.println(sol.coinChange(new int[]{1}, 0));
    }


    /**
     * Fn(11) = Min(F(9), F(8), F(6)) + 1
     * F(n) = Min(F(n-2), F(n-3), F(n-5)) + 1
     */
    private static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] ref = new int[amount + 1];

            Arrays.fill(ref, amount + 1);
            ref[0] = 0;

            for (int coin : coins) {
                for (int i = coin; i < ref.length; i++) {
                    ref[i] = Math.min(ref[i], ref[i - coin] + 1);
                    System.out.println("ref[" + i + "]" + ref[i]);
                }
            }
            return ref[amount] == amount + 1 ? -1 : ref[amount];
        }
    }
}
