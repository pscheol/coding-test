package com.coding.programmers.level1;

public class 푸드파이트대회 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,3,4,6}));
    }
    static class Solution {
        public String solution(int[] food) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int i = 1; i < food.length; i++) {
                for (int j = 0; j < food[i] / 2; j++) {
                    left.append(i);
                    right.insert(0, i);
                }
            }
            return left.toString().concat("0").concat(right.toString());
        }
    }
}
