package com.coding.exam;

import java.util.*;

public class 너비우선탐색순회 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6},
                {3, 7},
                {4, 8},
                {5, 8},
                {6, 9}
        }, 1, 9);
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution(new int[][]{
                {1, 3},
                {3, 4},
                {3, 5},
                {5, 2}
        }, 1, 5);
        System.out.println(Arrays.toString(result2));
    }
    private static class Solution {
        public int[] solution(int[][] graph, int start, int n) {
            List<List<Integer>> adjList = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] edge : graph) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            for (List<Integer> edge : adjList) {
                edge.sort(Comparator.naturalOrder());
            }

            return bfs(start, n, adjList);
        }

        private int[] bfs(int start, int n, List<List<Integer>> adjList) {
            int[] answer = new int[n];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            queue.add(start);
            visited.add(start);
            int cnt = 0;
            while (!queue.isEmpty()) {
                int dequeue = queue.removeFirst();
                answer[cnt++] = dequeue;
                for (Integer v : adjList.get(dequeue)) {
                    if (!visited.contains(v)) {
                        queue.add(v);
                        visited.add(v);
                    }
                }
            }
            return answer;
        }
    }
}
