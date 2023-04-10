package com.coding.backjoon;

import java.io.*;
import java.util.PriorityQueue;

public class 절대값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> pqueue = new PriorityQueue<>(
                (o1 ,o2) -> {
                    int first_abs = Math.abs(o1);
                    int second_abs = Math.abs(o2);
                    if (first_abs == second_abs) {
                        return o1 > o2 ? 1 : -1;
                    } else {
                        return first_abs - second_abs;
                    }
                });


        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pqueue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pqueue.poll() +"\n");
                }
            } else {
                pqueue.offer(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
