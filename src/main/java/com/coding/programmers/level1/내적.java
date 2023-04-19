package com.coding.programmers.level1;

public class 내적 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2});
        System.out.println(result);
    }

    static class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;

            for (int i = 0; i < a.length; i++) {
                answer += a[i] * b[i];
            }
            return answer;
        }
    }
}
