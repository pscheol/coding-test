package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class 전력망을둘로나누기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(9, new int[][]{
                {1,3},
                {2,3},
                {3,4},
                {4,5},
                {4,6},
                {4,7},
                {7,8},
                {7,9}
        });
        System.out.println(result);
    }
    private static class Solution {
        private static final List<List<Integer>> ADJ_LIST = new ArrayList<>();
        private int answer;
        private boolean[] visited;
        private int N;
        private int solution(int n, int[][] wires) {
            visited = new boolean[n + 1];
            N = n;
            answer = n - 1;
            for (int i = 0; i <= n; i++) {
                ADJ_LIST.add(new ArrayList<>());
            }

            for (int[] wire : wires) {
                ADJ_LIST.get(wire[0]).add(wire[1]);
                ADJ_LIST.get(wire[1]).add(wire[0]);
            }

            dfs(1);

            return answer;
        }
        public int dfs(int cur) {

            visited[cur] = true;

            int sum = 0;
            for (int next : ADJ_LIST.get(cur)) {
                if (!visited[next]) {
                    int count = dfs(next);
                    answer = Math.min(answer, Math.abs(N - count * 2));
                    sum += count;
                }
            }
            return sum + 1;
        }
    }
}
