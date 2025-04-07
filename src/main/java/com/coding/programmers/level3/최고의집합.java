package com.coding.programmers.level3;

import java.util.Arrays;

public class 최고의집합 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(2, 9);

        System.out.println(Arrays.toString(result));
    }
    static class Solution {
        public int[] solution(int n, int s) {
            if (s < n) return new int[] {-1};

            int[] answer = new int[n];

            int q = s / n;
            int r = s % n;

            for (int i = 0; i < n; i++) {
                if (i < n - r) {
                    answer[i] = q;
                } else {
                    answer[i] = q + 1;
                }
            }
            return answer;
        }
    }
}
