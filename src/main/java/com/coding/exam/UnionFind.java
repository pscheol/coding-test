package com.coding.exam;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionFind {
    public static void main(String[] args) {
        Solution sol = new Solution();

        Boolean[] result = sol.solution(3, new int[][]{
                {0,0,1},
                {0,1,2},
                {1,1,2}
        });
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        private static int[] parent;

        public Boolean[] solution(int k , int[][] operations) {
            this.parent = new int[k];

            for (int i = 0; i < k; i++) {
                parent[i] = i;
            }

            ArrayList<Boolean> answer = new ArrayList<>();

            for (int[] operation : operations) {
                if (operation[0] == 0) {
                    union(operation[1], operation[2]);
                } else {
                    answer.add(find(operation[1]) == find(operation[2]));
                }
            }
            return answer.toArray(new Boolean[0]);
        }

        private static int find(int x) {
            if (parent[x] == x) { //루트노드
                return x;
            }
            return find(parent[x]);
        }
        private static void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            parent[root2] = root1;
        }
    }
}
