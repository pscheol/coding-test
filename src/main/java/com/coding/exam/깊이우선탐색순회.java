package com.coding.exam;



import java.util.*;

public class 깊이우선탐색순회 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        }, 1, 5);
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution(new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6},
                {5, 6}
        }, 1, 6);
        System.out.println(Arrays.toString(result2));
    }
    private static class Solution {
        public int[] solution(int[][] graph, int start, int n) {
            List<List<Integer>> adjList = new ArrayList<>();
            //인접 리스트 초기화
            for (int i = 0; i < n + 1; i++) {
                adjList.add(new ArrayList<>());
            }
            //그래프를 인접 리스트로 변환
            for (int[] g : graph) {
                adjList.get(g[0]).add(g[1]);
                adjList.get(g[1]).add(g[0]);
            }

            for (List<Integer> edge : adjList) {
                edge.sort(Comparator.reverseOrder());
            }

            return dfs(start, n, adjList);
        }

        private int[] dfs(int start, int n, List<List<Integer>> adjList) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> visited = new HashSet<>();
            stack.add(start);
            visited.add(start);
            int[] answer = new int[n];
            int ansCnt = 0;

            while(!stack.isEmpty()) {
                int pop = stack.pop();

                answer[ansCnt++] = pop;
                List<Integer> popList = adjList.get(pop);

                for (int i : popList) {
                    if (!visited.contains(i)) {
                        visited.add(i);
                        stack.add(i);
                    }
                }
            }
            return answer;
        }
    }
}
