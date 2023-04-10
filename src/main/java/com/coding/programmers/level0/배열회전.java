package com.coding.programmers.level0;

import java.util.Arrays;

public class 배열회전 {
    public static void main(String[] args) {
        int[] arr = {4, 455, 6, 4, -1, 45, 6};
        System.out.println(Arrays.toString(solution(arr,"left")));
    }
    public static int[] solution(int[] numbers, String direction) {
        int length = numbers.length;
        int[] answer = new int[length];
        if (direction.equals("right")) {
            for (int i = 0; i < numbers.length; i++) {
                answer[(i+1) % length] = numbers[i];
            }
        } else {
            for (int i = length; i > 0; i--) {
                answer[i-1] = numbers[i % length];
            }
        }

        return answer;
    }
}
