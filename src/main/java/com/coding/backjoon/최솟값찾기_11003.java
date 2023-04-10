package com.coding.backjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NL = br.readLine().split(" ");
        int N = Integer.parseInt(NL[0]);
        int L = Integer.parseInt(NL[1]);

        Deque<Node> deque = new LinkedList<>();

        String[] A = br.readLine().split(" ");
        for (int i = 0; i < A.length; i++) {
            Node newNode = new Node(i, Integer.parseInt(A[i]));

            while (!deque.isEmpty() && deque.getLast().value > newNode.value) {
                deque.removeLast();
            }

            deque.addLast(newNode);

            if (i - L == deque.getFirst().idx) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static class Node {
        private int idx;
        private int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}