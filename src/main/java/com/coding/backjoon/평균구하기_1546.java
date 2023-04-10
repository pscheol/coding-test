package com.coding.backjoon;

import java.util.Scanner;

/**
 * ( A / (M * 100) + B / (M * 100) + C / (M * 100) ) / N
 * = ( A / M + B / M + C /M ) * 100 / N
 * = ( A + B +C ) * 100 / M / M
 */
public class 평균구하기_1546 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0 ; i < N; i++) {
            int num = scan.nextInt();
            M = Math.max(M, num);
            sum += num;
        }
        System.out.println((double)sum * 100 / M / N);
    }
}
