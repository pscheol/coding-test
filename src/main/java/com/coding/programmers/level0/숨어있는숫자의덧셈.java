package com.coding.programmers.level0;

import java.util.Stack;

public class 숨어있는숫자의덧셈 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("aAb1B2cC34oOp"));
        System.out.println(sol.solution("a10"));
        System.out.println(sol.solution(""));
    }
    private static class Solution {
        public int solution(String my_string) {
            int answer = 0;
            char[] chars = my_string.toCharArray();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (Character.isDigit(ch)) {
                    StringBuilder sb = new StringBuilder();
                    if (i > 0 && Character.isDigit(chars[i-1])) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                    stack.push(sb.toString());
                }
            }

            for (String s : stack) {
                answer += Integer.parseInt(s);
            }
            return answer;
        }
    }
}
