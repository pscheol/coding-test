package com.coding.programmers.level1;

import java.util.*;

/**
 *
 *             // 1 3 2 4 2
 *             // 1 X X 4 X  = 2
 *             // X X 2 X 2  = 2
 *             // X 3 1 1 X  = 2
 *
 *             //1 2 3 4 5
 *             //1 2 3 4 5 = 5
 *             //X X X X X = 0
 *             //X X X X X = 0*
 */
public class 모의고사 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1,3,2,4,2})));
    }

    static class Solution {
        public static int[][] STD = {
                { 1, 2, 3, 4, 5}
                , { 2, 1, 2, 3, 2, 4, 2, 5}
                , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        public int[] solution(int[] answers) {
            int[] score = {0,0,0};
            for (int i = 0; i < STD.length; i++) {
                for (int i1 = 0; i1 < answers.length; i1++) {
                    if (answers[i1] == STD[i][i1 % STD[i].length]) {
                        score[i]++;
                    }
                }
            }

            //최대점수
            int max = Math.max(score[0], Math.max(score[1], score[2]));
            //최대점수 수포자
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < score.length; i++) {
                if (max == score[i]) {
                    ans.add(i+1);
                }
            }

            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
