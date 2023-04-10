package com.coding.programmers.level0;

public class 공던지기 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        System.out.println(solution(arr, 2));
    }
    public static int solution(int[] numbers, int k) {
        return  numbers[2 * (k-1) % numbers.length];
    }
}
