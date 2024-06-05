package com.coding.exam;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.kruskal(4, new int[][] {
                {0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
        });
        System.out.println(result);
    }
    private static class Solution {
        private int[] parent; //부모노드
        private int[] rank; //각 집합의 크기
        public int kruskal(int n, int[][] costs) {

            init(n);

            //가중치 값 작은 순으로 정렬
            Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

            int cost = 0;
            int edges = 0;

            //간선수 n -1
            for (int[] edge : costs) {

                if (edges == n - 1) {
                    break;
                }

                //서로 속한 집합이 다르면
                if (find(edge[0]) != find(edge[1])) {
                    unionByRank(edge[0], edge[1]); //두 집합을 합친다.
                    cost += edge[2];
                    edges++;
                }
            }
            System.out.println(Arrays.toString(rank));
            return cost;
        }

        /**
         * 초기화
         * @param n
         */
        private void init(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            //경로 압축
            return parent[x] = find(parent[x]);
        }


        private void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);

            if (root1 == root2) {
                return;
            }

            if (root1 < root2) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }
        }

        /**
         * 두 트리를 합칠 때 높이가 더 낮은 트리를 높이가 높은 트리의 밑에 자손을 넣어주는 방식
         * 메모리를 배로 사용하므로 공간복잡도가 늘어난다.
         * @param x
         * @param y
         */
        private void unionByRank(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);

            if (root1 == root2) {
                return;
            }

            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else { //rank[root1] == rank[root2]
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }

}
