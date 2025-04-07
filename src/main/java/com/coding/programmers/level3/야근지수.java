package com.coding.programmers.level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        long result = sol.solution(4, new int[]{4, 3, 3});
        System.out.println(result);

        long result2 = sol.solution(1, new int[]{2,1,2});
        System.out.println(result2);

        long result3 = sol.solution(3, new int[]{1,1});
        System.out.println(result3);
    }
    static class Solution {
        public long solution(int n, int[] works) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int work : works) {
                queue.add(work);
            }

            int remain = n;

            while (remain > 0 && !queue.isEmpty()) {
                int work = queue.poll();
                if (work == 0) {
                    break;
                }
                queue.add(work - 1);
                remain--;
            }

            long answer = 0;
            while (!queue.isEmpty()) {
                int work = queue.poll();
                answer += (long) work * work;
            }
            return answer;
        }
    }
}
