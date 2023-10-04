package com.coding.programmers.level2;


import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("baabaa"));
        System.out.println(sol.solution("cdcd"));
    }
    private static class Solution
    {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (!stack.isEmpty() && stack.peek() == chs[i]) {
                    stack.pop();
                } else {
                    stack.push(chs[i]);
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
