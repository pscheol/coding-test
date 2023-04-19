package com.coding.programmers.level1;


import java.util.Arrays;

public class 제일작은수제거하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution.solution(new int[]{10})));
    }

    static class Solution {
        public int[] solution(int[] arr) {
            int[] answer = new int[arr.length - 1];
            int min = arr[0];
            int idx = 0;
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    idx = i;
                }
            }
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if (idx != i) {
                    answer[k++] = arr[i];
                }
            }

            if (answer.length == 0) {
                answer = new int[1];
                answer[0] = -1;
            }
            return answer;
        }
    }
}
