package com.coding.programmers.level1;

import java.util.Map;

public class 숫자문자열과영단어 {
    public static final Map<String, Integer> DIGIT = Map.of(
            "zero", 0, "one", 1, "two", 2,
            "three", 3, "four", 4, "five", 5,
            "six", 6, "seven", 7, "eight", 8, "nine", 9);

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("one4seveneight"));
    }
    static class Solution {
        public int solution(String s) {
            char[] chars = s.toCharArray();
            StringBuilder result = new StringBuilder();
            String check = "";
            for (char ch : chars) {
                check += ch;
                Integer num = DIGIT.get(check);
                if (Character.isDigit(ch) || num != null) {
                    check = "";
                    int n = num != null ? num : Character.digit(ch, 10);
                    result.append(n);
                }
            }
            return Integer.parseInt(result.toString());
        }
    }
}
