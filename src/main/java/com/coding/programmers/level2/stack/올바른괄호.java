package com.coding.programmers.level2.stack;


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
                } else if (stack.isEmpty() || stack.pop() == ch) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
        boolean solution2(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count = s.charAt(i) == '(' ? count + 1 : count -1;
                if (count < 0) {
                    break;
                }
            }

            return count == 0;
        }
    }
}
