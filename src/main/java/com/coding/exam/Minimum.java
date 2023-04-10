package com.coding.exam;

import java.util.Deque;
import java.util.LinkedList;

public class Minimum {
    public static void main(String[] args) {
        int N = 12;
        int L = 3;
        int[] arr = {1,5,2,3,6,2,3,7,3,5,2,6};
        Deque<Node> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];

            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }

            deque.addLast(new Node(now, i));

            System.out.println("i - L=" + (i - L) + ", deque.getFirst().index=" + deque.getFirst().index );
            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
