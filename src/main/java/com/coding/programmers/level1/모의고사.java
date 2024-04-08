package com.coding.programmers.level1;

import java.util.*;

public class 모의고사 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1,3,2,4,2})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1,4,2,4,2})));
    }

    static class Solution {
        public static int[][] PATTERN = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        public int[] solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();
            int[] std = new int[3];

            for (int i = 0; i < answers.length; i++) {
                std[0] += (PATTERN[0][i % 5] == answers[i]) ? 1 : 0;
                std[1] += (PATTERN[1][i % 8] == answers[i]) ? 1 : 0;
                std[2] += (PATTERN[2][i % 10] == answers[i]) ? 1 : 0;
            }

            int max = Math.max(std[0], Math.max(std[1], std[2]));
            for (int i = 0; i < std.length; i++) {
                if (std[i] == max) {
                    answer.add(i + 1);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
