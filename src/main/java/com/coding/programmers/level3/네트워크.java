package com.coding.programmers.level3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 네트워크 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(3, new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        });
        System.out.println(result);

        int result2 = sol.solution(3, new int[][] {
                {1,1,0},
                {1,1,1},
                {0,0,1}
        });
        System.out.println(result2);


        Solution2 sol2 = new Solution2();
        int result3 = sol2.solution(3, new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        });
        System.out.println(result3);

        int result4 = sol2.solution(3, new int[][] {
                {1,1,0},
                {1,1,1},
                {0,0,1}
        });
        System.out.println(result4);
    }
    private static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(computers, visited, i);
                    answer++;
                }
            }

            return answer;
        }


        private void dfs(int[][] computers, boolean[] visited, int vertex) {
            //현재노드 방문 표시
            visited[vertex] = true;

            for (int v = 0; v < computers[vertex].length; v++) {
                //네트워크 연결이 1 이고 방문하지 않았으면
                if (computers[vertex][v] == 1 && !visited[v]) {
                    dfs(computers, visited, v);
                }
            }
        }
    }

    private static class Solution2 {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            Set<Integer> visited = new HashSet<>();

            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    dfs(computers, visited, i);
                    answer++;
                }
            }

            return answer;
        }


        private void dfs(int[][] computers, Set<Integer> visited, int vertex) {
            Stack<Integer> stack = new Stack<>();
            stack.add(vertex);

            while (!stack.isEmpty()) {
                int pVertex = stack.pop();
                for (int v = 0; v < computers[pVertex].length; v++) {
                    //네트워크 연결이 1 이고 방문하지 않았으면
                    if (computers[pVertex][v] == 1 && !visited.contains(v)) {
                        stack.add(v);
                        //현재노드 방문 표시
                        visited.add(v);
                    }
                }
            }
        }
    }
}
