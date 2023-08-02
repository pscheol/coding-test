package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 과일장수 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
    private static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            List<Integer> arr = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

            for (int i = m - 1; i < arr.size(); i+=m) {
                answer +=(arr.get(i) * m);

            }
            return answer;
        }
        public int sol2(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            for(int i = score.length; i >= m; i -= m){
                answer += score[i - m] * m;
            }

            return answer;
        }
    }
}
