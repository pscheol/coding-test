package com.coding.programmers.level1;

public class 두정수의합 {
    public static void main(String[] args) {
        System.out.println(solution(3, 3));
    }
    public static long solution(int a, int b) {
        long answer = 0;
        int start = a;
        int end = b;
        int tmp;
        if (start > end) {
            tmp = start;
            start = end;
            end = tmp;
        }

        for (int i = start; i <= end; i++) {
            answer += i;
        }
        return answer;
    }

    public static long solution2(int a, int b) {
        return seqSum(Math.min(a, b), Math.max(a, b));
    }

    /**
     * * 등차수열 합
     * Sn = n[2a +(n-1)d] / 2
     * @param a
     * @param b
     * @return
     */
    private static long seqSum(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}
