package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 요세푸스문제_1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        System.out.println(solution(n, k));

    }

    public static String solution(int n, int k) {
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(String.valueOf(i + 1));
        }

        StringBuilder sb = new StringBuilder("<");
        while(!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        return sb.toString();
    }

    public static String josephusProblem(int n, int m) {
        List<Integer> ar = new ArrayList<>();
        StringBuilder sb = new StringBuilder("<");
        for (int i = 1; i <=n; i++) {
            ar.add(i);
        }
        int idx = 0, i =0;
        while(!ar.isEmpty()) {
            idx = (idx + m-1) % ar.size();
            sb.append(ar.remove(idx));
            if (!ar.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        return sb.toString();
    }
}
