package com.coding.programmers.level1;

import java.util.Arrays;


public class 없는숫자더하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(sol.solution3(new int[]{5,8,4,0,6,7,9}));

    }

    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            int[] nums = new int[10];

            for (int i = 0; i < numbers.length; i++) {
                nums[numbers[i]]++;
            }

            for (int i = 0; i <= 9; i++) {
                if (nums[i] == 0) {
                    answer += i;
                }
            }
            return answer;
        }

        public int solution2(int[] numbers) {
            int answer = 45;

            for (int num : numbers) {
                answer-= num;
            }
            return answer;
        }

        public int solution3(int[] numbers) {
            return 45 - Arrays.stream(numbers).sum();
        }
    }
}
