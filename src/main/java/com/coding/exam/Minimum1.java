package com.coding.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Minimum1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Node> deque = new LinkedList<>();
        int slide = line1[1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            while (!deque.isEmpty() && deque.getLast().value > arr[i]) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, arr[i]));

            if (deque.getFirst().index <= i - slide) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
