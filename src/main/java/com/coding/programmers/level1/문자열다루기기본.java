package com.coding.programmers.level1;

public class 문자열다루기기본 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1234"));
    }
    static class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            char[] chs = s.toCharArray();
            if (chs.length != 4 && chs.length != 6) {
                return false;
            }

            for (int i = 0; i < chs.length; i++) {
                if (chs[i] < 48 || chs[i] > 57) {
                    answer = false;
                    break;
                }
            }
            return answer;
        }
    }
}
