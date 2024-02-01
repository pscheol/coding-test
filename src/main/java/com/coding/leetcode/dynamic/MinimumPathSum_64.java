package com.coding.leetcode.dynamic;

public class MinimumPathSum_64 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.minPathSum(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        });
        System.out.println(result);
    }
    private static class Solution {
        public int minPathSum(int[][] grid) {
            int y = grid.length;
            int x = grid[0].length;
            int[][] ref = new int[y][x];
            ref[0][0] = grid[0][0];

            //init x
            for (int i = 1; i < x; i++) {
                ref[0][i] = grid[0][i] + ref[0][i-1];
            }
            //init y
            for (int i = 1; i < y; i++) {
                ref[i][0] = grid[i][0] + ref[i-1][0];
            }

            //bottom up
            for (int i = 1; i < y; i++) {
                for (int j = 1; j < x; j++) {
                    ref[i][j] = grid[i][j] + Math.min(ref[i-1][j], ref[i][j-1]);
                }
            }

            return ref[y-1][x-1];
        }
    }
}
