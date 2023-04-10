package com.coding.backjoon;

import java.util.Scanner;

public class 연속된자연수합구하기_2018 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(sum(scan.nextInt()));
    }

    public static int sum(int N) {
        int s = 1;
        int e = 1;
        int sum = 1;
        int cnt = 1;
        while (e != N) {
            if (sum == N) {
                cnt++;
                e++;
                sum += e;
            } else if (sum > N) {
                sum -= s;
                s++;
            } else {
                 e++;
                sum += e;
            }
        }
        return cnt;
    }
}
