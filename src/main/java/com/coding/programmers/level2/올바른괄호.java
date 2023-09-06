package com.coding.programmers.level2;


import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("()()"));
        System.out.println(sol.solution("(())()"));
        System.out.println(sol.solution(")()("));
        System.out.println(sol.solution("(()("));


    }
    private static class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chs = s.toCharArray();
            for (char ch : chs) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')' && !stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
