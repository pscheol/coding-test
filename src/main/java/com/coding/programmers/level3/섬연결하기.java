package com.coding.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(4, new int[][] {
                {0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
        });
        System.out.println(result);
    }
    private static class Solution {
        private int[] parent;
        public int solution(int n, int[][] costs) {

            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }

            Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

            int answer = 0;
            int edges = 0;
            for (int[] edge : costs) {
                if (edges == n - 1) {
                    break;
                }

                if (find(edge[0]) != find(edge[1])) {
                    union(edge[0], edge[1]);
                    answer += edge[2];
                    edges++;
                }
            }

            return answer;
        }
        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        private void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            parent[root2] = root1;
        }
    }

}
