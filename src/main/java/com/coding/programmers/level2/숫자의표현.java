package com.coding.programmers.level2;

public class 숫자의표현 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(15));
    }
    private static class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    answer++;
                }
            }

            return answer;
        }

        public int solution2(int n) {
            int answer = 0;
            int num = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                num = i;
                sum = 0;
                while (sum < n) {
                    sum+= num++;
                }
                if (sum == n) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
