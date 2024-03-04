package com.coding.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));

    }
    private static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> ref = new ArrayList<>();
            long ans = 1L;
            ref.add(1);

            for (int i = 1; i <= rowIndex; i++) {
                ans = (ans * (rowIndex - i + 1)) / i;
                ref.add((int) ans);
            }
            return ref;
        }
    }
}
