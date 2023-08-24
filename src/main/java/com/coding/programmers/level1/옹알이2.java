package com.coding.programmers.level1;

public class 옹알이2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"aya","yee","u", "maa"}));
        System.out.println(sol.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
    private static class Solution {
        private static final String regex1 = "ayaaya|yeye|woowoo|mama";
        private static final String regex2 = "aya|ye|woo|ma";
        public int solution(String[] babbling) {
            int answer = 0;
            for (String b : babbling) {
                String bWord = b;
                bWord = bWord.replaceAll(regex1, " ");
                bWord = bWord.replaceAll(regex2, "");
                if (bWord.length() == 0) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
