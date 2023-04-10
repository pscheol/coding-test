package com.coding.backjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        boolean result = true;
        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();

            if (cnt <= m) {
                while (cnt <= m) {
                    stack.push(cnt++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();
                if (pop > m) {
                    result = false;
                    System.out.println("NO");
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(sb.toString());
        }
    }
}
