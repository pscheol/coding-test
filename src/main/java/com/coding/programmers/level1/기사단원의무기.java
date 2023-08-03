package com.coding.programmers.level1;

import java.util.Arrays;

public class 기사단원의무기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10, 3, 2));
    }
    static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] divisor = divisorCount(number);
            for (int p : divisor) {
                answer += p > limit ? power : p;
            }
            return answer;
        }

        public int[] divisorCount(int number) {
            int[] result = new int[number + 1];
            for (int i = 1 ; i <= number; i++) {
                int count = divisor(i);
                result[i] = count;
            }
            return result;
        }

        private int divisor(int number) {
            int count = 0;
            for (int i = 1; i * i <= number; i++) {
                if (i * i == number) {
                    count++;
                } else if (number % i == 0) {
                    count+=2;
                }
            }
            return count;
        }
    }
}
