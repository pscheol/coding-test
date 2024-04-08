package com.coding.programmers.level1;

import java.util.*;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(sol.solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(sol.solution(new int[]{3,2,6}, 10)));
    }
    private static class Solution {
        public int[] solution(int[] arr, int divisor) {
            List<Integer> answer = new ArrayList<>();
            for (int num : arr) {
                if (num % divisor == 0) {
                    answer.add(num);
                }
            }
            if (answer.isEmpty()) {
                answer.add(-1);
            }
            return answer.stream()
                    .sorted()
                    .mapToInt(Integer::intValue).toArray();
        }
    }
}
