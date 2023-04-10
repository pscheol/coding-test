package com.coding.exam;

public class Divide {
    public static void main(String[] args) {
        int n = 123;

        int answer = 0;
        int tmp = n;
        while (tmp != 0) {
            answer += (tmp % 10);
            System.out.println(answer);
            tmp /= 10;
        }

    }
}
