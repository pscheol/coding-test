package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (d(i) == n) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
    public static int d(int num) {
        int result = num;
        while (num != 0) {
            result += (num % 10);
            num /= 10;
        }
        return result;
    }
}
