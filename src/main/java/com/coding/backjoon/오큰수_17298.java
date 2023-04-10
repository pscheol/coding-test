package com.coding.backjoon;

import java.io.*;
import java.util.Stack;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] ns = br.readLine().split(" ");
        int[] A = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < ns.length; i++) {
            A[i] = Integer.parseInt(ns[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = A[i];
            while (!stack.isEmpty() && A[stack.peek()] < a) {
                answer[stack.pop()] = a;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()] = - 1;
        }

        for (int ans : answer) {
            bw.write(ans + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();

    }
}
