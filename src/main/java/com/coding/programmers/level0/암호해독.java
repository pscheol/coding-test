package com.coding.programmers.level0;

public class 암호해독 {
    public static void main(String[] args) {
        System.out.println(solution("dfjardstddetckdaccccdegk", 4));
    }
    public static String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipher.length() / code; i++) {
            sb.append(cipher.charAt((i + 1)* code - 1));
        }
        return sb.toString();
    }
}
