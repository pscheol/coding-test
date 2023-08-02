package com.coding.programmers.level1;

public class 이천십육년 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 24));
    }

    static class Solution {
        String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public String solution(int a, int b) {
            int day = 0;
            for (int i = 0; i < a - 1; i++) {
                day += months[i];
            }
            return weeks[(day + b - 1) % 7];
        }
    }
}
