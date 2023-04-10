package com.coding.programmers.level0;

public class 자리수더하기 {
    public static void main(String[] args) {
        int n = 930211;
        int answer = 0;
        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }
        System.out.println(answer);

    }
}
