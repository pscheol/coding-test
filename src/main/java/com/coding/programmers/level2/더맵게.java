package com.coding.programmers.level2;

import java.util.*;

public class 더맵게 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(result);

        int result2 = sol.solution(new int[]{10, 1,1,1}, 10);
        System.out.println(result2);
    }
    private static class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int s : scoville) {
                queue.add((long)s);
            }
            int answer = queue.isEmpty() ? -1 : 0;
            while (queue.size() > 1 && answer != -1 && K > queue.peek()) {
                answer++;
                long s1 = queue.poll();
                long s2 = queue.poll();
                long s = s1 + (s2 * 2);
                queue.offer(s);
            }

            return queue.peek() < K ? -1 : answer;
        }
    }
}
