package com.coding.etc;

import java.util.Stack;

public class 십진수를이진수로변환 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(27));
    }
    private static class Solution {
        public String solution(int deciaml) {
            Stack<Integer> stack = new Stack<>();
            while (deciaml > 0) {
                stack.push(deciaml % 2);
                deciaml /= 2;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }
}
