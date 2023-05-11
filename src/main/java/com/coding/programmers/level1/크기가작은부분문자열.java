package com.coding.programmers.level1;

import java.util.stream.LongStream;

public class 크기가작은부분문자열 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("3141592", "271"));
        System.out.println(sol.solution2("3141592", "271"));
        System.out.println(sol.solution3("3141592", "271"));

    }
    static class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            int slide = p.length();
            char[] tt = t.toCharArray();;

            for (int i = slide; i <= tt.length; i++) {
                int window = i - slide;
                StringBuilder check = new StringBuilder();
                for (int j = window; j < slide + window; j++) {
                    check.append(tt[j]);
                }
                if (Long.parseLong(check.toString()) <= Long.parseLong(p)) {
                    answer++;
                }
            }
            return answer;
        }
        public int solution2(String t, String p) {
            int answer = 0;
            long check = Long.parseLong(p);
            int slide = p.length();
            for (int i = 0; i <= t.length() - slide; i++) {
                if (Long.parseLong(t.substring(i, i + slide)) <= check) {
                    answer++;
                }
            }
            return answer;
        }
        public int solution3(String t, String p) {
            long check = Long.parseLong(p);
            int slide = p.length();

            return (int) LongStream.range(0L, t.length() - slide + 1)
                    .mapToObj(i -> Long.parseLong(t.substring((int) i, (int) (i + slide))) <= check)
                    .filter(f -> f)
                    .count();

        }
    }
}
