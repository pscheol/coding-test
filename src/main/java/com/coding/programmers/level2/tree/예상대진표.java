package com.coding.programmers.level2.tree;

public class 예상대진표 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(8, 4, 7);
        System.out.println(result);
    }
    private static class Solution {
        public int solution(int n, int a, int b) {
            int answer;
            for (answer = 0; a != b; answer++) {
                a = (a + 1) / 2;
                b = (b + 1) / 2;
            }
            return answer;
        }
    }
}
