package com.coding.programmers.level0;

import java.util.Arrays;
import java.util.Comparator;

public class 평행 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result1 = sol.solution(new int[][] {
                {1, 4}, {9, 2}, {3, 8}, {11, 6}
        });

        System.out.println(result1);
        int result2 = sol.solution(new int[][] {
                {1, 2}, {5, 1}, {3, 6}, {6, 3}
        });
        System.out.println(result2);

        int result3 = sol.solution(new int[][] {
                {1, 4},
                {2, 1},
                {3, 2},
                {4, 7}
        });
        System.out.println(result3);
    }

    private static class Solution {
        public int solution(int[][] dots) {
            Arrays.sort(dots, Comparator.comparingInt(o -> o[0]));
            double xy1 = (double) (dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]);
            double xy2 = (double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]);
            return xy1 == xy2 ? 1 : 0;
        }
    }
}
