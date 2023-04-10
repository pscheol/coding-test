package com.coding.programmers.level0;

import java.util.Arrays;

public class Ar {
    public static void main(String[] args) {
     int[] arr = {4,3,2,1};
        System.out.println(Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[] numbers) {
        if (numbers.length <= 1) {
            return new int[]{-1};
        }
        int length = numbers.length;
        int[] answer = new int[length - 1];

        int min = numbers[0];
        for (int i = 1; i < length; i++) {
            min = Math.min(min, numbers[i]);
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] != min) {
                answer[i] = numbers[i];
            }
        }
        return answer;
    }
}
