package com.coding.backjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11720
 */
public class 숫자의합_11720 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = 0;
        int line = scan.nextInt();
        String nStr = scan.next();
        if (line == nStr.length()) {
            for (char c : nStr.toCharArray()) {
                answer += (c - '0');
            }
        }
        System.out.println(answer);
    }
}
