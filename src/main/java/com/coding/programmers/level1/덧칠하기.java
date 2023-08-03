package com.coding.programmers.level1;

public class 덧칠하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8,4, new int[]{2,3,6}));
        System.out.println(sol.solution(5,4, new int[]{1,3}));
        System.out.println(sol.solution(4,1, new int[]{1,2,3,4}));
    }
    static class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 1;
            int start = section[0];

            for (int item : section) {
                if (start + m <= item) {
                    start = item;
                    answer++;
                }
            }

            return answer;
        }
    }
}
