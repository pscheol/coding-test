package com.coding.programmers.level1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 카드뭉치 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(sol.solution2(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));


    }

    static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";
            int c1Cnt = 0;
            int c2Cnt = 0;
            for (String s : goal) {
                if (cards1.length > c1Cnt && s.equals(cards1[c1Cnt])) {
                    c1Cnt++;
                } else if (cards2.length > c2Cnt && s.equals(cards2[c2Cnt])) {
                    c2Cnt++;
                } else {
                    answer = "No";
                    break;
                }
            }
            return answer;
        }

        public String solution2(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";
            ArrayDeque<String> card1Deque = new ArrayDeque<>(Arrays.asList(cards1));
            ArrayDeque<String> card2Deque = new ArrayDeque<>(Arrays.asList(cards2));
            ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

            while(!goalDeque.isEmpty()) {
                String card = goalDeque.poll();
                if (!card1Deque.isEmpty() && card1Deque.peekFirst().equals(card)) {
                    card1Deque.poll();
                } else if (!card2Deque.isEmpty() && card2Deque.peekFirst().equals(card)) {
                    card2Deque.poll();
                } else {
                    answer = "No";
                    break;
                }
            }
            return answer;
        }
    }
}
