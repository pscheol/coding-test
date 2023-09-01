package com.coding.programmers.level1;


import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(sol.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
        System.out.println(sol.solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1}));

    }

    private static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            int cnt = 0;
            Stack<Integer> stack = new Stack<>();
            for (int item : ingredient) {
                stack.push(item);
                cnt++;
                if (stack.size() >= 4) {
                    if (stack.get(cnt - 4) == 1 && stack.get(cnt - 3) == 2 && stack.get(cnt - 2) == 3 && stack.get(cnt - 1) == 1) {
                        answer++;
                        for (int i = 0 ; i < 4; i ++) {
                            stack.pop();
                            cnt--;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
