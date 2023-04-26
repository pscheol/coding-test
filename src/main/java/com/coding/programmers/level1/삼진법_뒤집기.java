package com.coding.programmers.level1;


import java.util.Stack;

public class 삼진법_뒤집기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution3(45));
    }
    static class Solution {
        public int solution(int n) {
            int answer = 0;

            String ternary = Integer.toString(n,3);
            Stack<Character> stack = new Stack<>();
            char[] chs = ternary.toCharArray();
            for (char ch : chs) {
                stack.add(ch);
            }


            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            String replace = sb.toString();

            answer = Integer.parseInt(replace, 3);

            return answer;
        }

        public int solution2(int n) {
            String ternary = Integer.toString(n,3);
            StringBuilder sb = new StringBuilder(ternary);
            return Integer.parseInt(sb.reverse().toString(), 3);
        }

        public int solution3(int n) {
            StringBuilder a = new StringBuilder();
            while(n > 0) {
                a.append(n % 3);
                n /= 3;
            }
            return Integer.parseInt(a.toString(), 3);
        }


    }
}
