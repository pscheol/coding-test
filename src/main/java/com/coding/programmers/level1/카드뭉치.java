package com.coding.programmers.level1;

public class 카드뭉치 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
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
    }
}
