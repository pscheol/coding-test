package com.coding.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
        System.out.println(solution.generate2(5));

    }
    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(List.of(1));

            for (int i = 1; i < numRows; i++) {
                List<Integer> ref = new ArrayList<>();
                List<Integer> before = result.get(i-1);
                ref.add(1);
                for (int j = 1; j < i; j++) {
                    ref.add(before.get(j) + before.get(j-1));
                }
                ref.add(1);
                result.add(ref);
            }
            return result;
        }

        public List<List<Integer>> generate2(int numRows) {
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 1; i <= numRows; i++) {
                List<Integer> ref = new ArrayList<>();
                int ans = 1;
                ref.add(ans);

                for (int j = 1; j < i; j++) {
                    ans = (ans * (i - j)) / j;
                    ref.add(ans);
                }
                result.add(ref);
            }
            return result;
        }
    }
}
