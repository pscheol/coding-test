package com.coding.programmers.level0;

import java.util.Arrays;

public class N의배수고르기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})));
    }
    public static int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(num -> num % n == 0).toArray();
    }
}
