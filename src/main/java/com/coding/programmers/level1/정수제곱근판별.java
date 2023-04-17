package com.coding.programmers.level1;

public class 정수제곱근판별 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static long solution(long n) {
        long x = (long) Math.sqrt(n);
        return Math.pow(x, 2) == n ? (long) Math.pow(x + 1,2) : -1;
    }
}
