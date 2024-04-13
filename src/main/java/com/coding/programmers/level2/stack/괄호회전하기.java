package com.coding.programmers.level2.stack;

import java.util.Map;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("[](){}"));
        System.out.println(sol.solution("}]()[{"));
        System.out.println(sol.solution("[)(]"));
        System.out.println(sol.solution("}}}"));

    }

    private static class Solution {
        private static final Map<Character, Character> CHECK = Map.of(
                        '(', ')',
                        '{', '}',
                        '[', ']');
        public int solution(String s) {
            int answer = 0;
            char[] chars = s.toCharArray();

            A:for (int i = 0; i < chars.length; i++) {
                Stack<Character> stack = new Stack<>();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[(i + j) % chars.length];
                    if (CHECK.containsKey(ch)) {
                        stack.push(ch);
                    } else if (stack.isEmpty() || CHECK.get(stack.pop()) != ch) {
                        continue A;
                    }
                }
                if (stack.isEmpty()) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
