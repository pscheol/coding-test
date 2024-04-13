package com.coding.programmers.level2.stack;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[]{1,2,3,2,3});
        System.out.println(Arrays.toString(result));
        int[] result2 = sol.solution(new int[]{1, 6, 9, 5 ,3 ,2 ,7});
        System.out.println(Arrays.toString(result2));
        int[] result3 = sol.solution(new int[]{1,6,9,5});
        System.out.println(Arrays.toString(result3));
    }

    private static class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int j = stack.pop();
                    answer[j] = i - j;
                }
                stack.push(i);
            }


            while (!stack.isEmpty()) {
                int i = stack.pop();
                answer[i] = n - 1 - i;
            }
            return answer;
        }
    }
}
