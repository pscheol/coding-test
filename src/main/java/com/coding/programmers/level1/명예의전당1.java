package com.coding.programmers.level1;

import java.util.*;

public class 명예의전당1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(sol.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }
    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            Queue<Integer> queue = new PriorityQueue<>();

            for (int i = 0; i < score.length; i++) {
                if (queue.size() < k) {
                    queue.add(score[i]);
                } else { //큐에 데이터가 k개 이상일 경우
                    if (!queue.isEmpty() && queue.peek() < score[i]) {
                        queue.poll();
                        queue.add(score[i]);
                    }
                }
                if (!queue.isEmpty())
                    answer[i] = queue.peek();
            }

            return answer;
        }
    }
}
