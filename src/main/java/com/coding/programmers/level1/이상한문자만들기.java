package com.coding.programmers.level1;

public class 이상한문자만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("try hello world"));
    }
    static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();
            
            char[] chs = s.toCharArray();
            int i = 0;
            for (char ch : chs) {
                if (ch == ' ') {
                    answer.append(ch);
                    i = 0;
                } else if (i % 2 == 0) {

                    answer.append(String.valueOf(ch).toUpperCase());
                    i++;
                } else {
                    answer.append(String.valueOf(ch).toLowerCase());
                    i++;
                }
            }

            return answer.toString();
        }
    }
}
