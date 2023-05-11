package com.coding.programmers.level1;


import java.util.Arrays;
import java.util.Stack;

public class 예산 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution2(new int[]{1,3,2,5,4}, 9));
        System.out.println(sol.solution2(new int[]{2,2,3,3}, 10));
        System.out.println(sol.solution2(new int[]{4}, 3));
    }
    static class Solution {
        public int solution(int[] d, int budget) {
            Stack<Integer> stack = new Stack<>();
            Arrays.sort(d);
            int check = 0;
            for (int i : d) {
                check += i;
                if (check <= budget) {
                    stack.push(i);
                } else if (!stack.isEmpty()) {
                    check -= stack.pop();
                    stack.push(i);
                }
            }
            return stack.size();
        }

        public int solution2(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            int check = 0;
            for (int i : d) {
                check += i;
                if (check <= budget) {
                    answer++;
                } else {
                    break;
                }
            }
            return answer;
        }
    }
}
