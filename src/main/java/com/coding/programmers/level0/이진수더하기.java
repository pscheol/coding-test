package com.coding.programmers.level0;

import java.util.function.IntBinaryOperator;

public class 이진수더하기 {
    public static void main(String[] args) {
        System.out.println(solution("10", "11"));
    }
    public static String solution(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1,2) + Integer.parseInt(bin2,2));
    }
}
