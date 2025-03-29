package com.coding.codility.lesson;

import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[] {3,8,9,7,6}, 3);

        System.out.println(Arrays.toString(result));
    }
    static class Solution {
        public int[] solution(int[] A, int K) {
            int seq = 0;
            int[] answer = new int[A.length];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int a : A) {
                queue.offer(a);
            }

            while (K < seq++) {
                queue.offer(queue.poll());
            }
            System.out.println();
            int i = 0;
            while (!queue.isEmpty()) {
                answer[i] = A[seq % 5];
            }

            return answer;
        }
        public int[] solution2(int[] A, int K) {
            List<Integer> list = new LinkedList<>();
            for(int i:A){
                list.add(i);
            }
            Collections.rotate( list, K);
            int size = list.size();

            int[] answer = new int[size];
            for (int i = 0 ; i < list.size() ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
