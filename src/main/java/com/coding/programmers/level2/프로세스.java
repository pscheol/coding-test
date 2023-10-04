package com.coding.programmers.level2;

import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {2,1,3,2}, 2));
        System.out.println(sol.solution(new int[] {1,1,9,1,1,1}, 0));
    }
    private static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Node> queue = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                Node node = new Node(i, priorities[i]);
                queue.offer(node);
            }

            while (!queue.isEmpty()) {
                Node dq = queue.poll();
                boolean check = true;
                for (Node q : queue) {
                    if (dq.priority < q.priority) {
                        queue.offer(dq);
                        check = false;
                        break;
                    }
                }

                if (check) {
                    answer++;
                    if (dq.loc == location) {
                        break;
                    }
                }
            }

            return answer;
        }
        private static class Node {
            private int loc;
            private int priority;

            public Node(int loc, int priority) {
                this.loc = loc;
                this.priority = priority;
            }
        }
    }
}
