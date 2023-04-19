package com.coding.programmers.level1;

/**
 * 약수의 개수가 짝수면 더 하고
 * 약수의 개수가 홀 수면 뺸다.
 */
public class 약수의개수와덧셈 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(13, 17));
        System.out.println(sol.solution1(13, 17));
    }

    static class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right; i++) {
                answer = divisor(i) % 2 == 0 ? (answer + i) : (answer - i);
            }
            return answer;
        }

        public int solution1(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right; i++) {
                answer = i % Math.sqrt(i) == 0 ? answer - i : answer + i;
            }
            return answer;
        }

        private int divisor(int i) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count++;
                    if (i / j != j) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
