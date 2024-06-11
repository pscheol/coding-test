package com.coding.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellManFord {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[][] {
                {1,2,7},
                {1,3,5},
                {1,4,3},
                {3,4,3},
                {3,5,3},
                {4,2,3},
                {4,5,-6},
                {5,3,2},
        }, 1, 7);
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution2(new int[][] {
                {1,2,7},
                {1,3,5},
                {1,4,3},
                {3,4,3},
                {3,5,3},
                {4,2,3},
                {4,5,-6},
                {5,3,2},
        }, 1, 7);
        System.out.println(Arrays.toString(result2));
    }
    private static class Solution {
        private static final int INF = Integer.MAX_VALUE;

        public int[] solution(int[][] graph, int start, int n) {
            List<List<Node>> adjList = initAdjList(graph, n);

            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[start] = 0;

            //정점 수 만큼 반복
            for (int v = 1; v <= n; v++) {
                //모든 간선을 순회
                for (Node node : adjList.get(v)) {
                    if (dist[node.from] == INF) {
                        continue;
                    }

                    if (dist[node.to] > dist[node.from] + node.cost) {
                        dist[node.to] = dist[node.from] + node.cost;
                    }
                }
            }
            return dist;
        }
        private int[] solution2(int[][] graph, int start, int n) {
            List<List<Node>> adjList = initAdjList(graph, n);

            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[start] = 0;

            //정점 수 만큼 반복
            for (int v = 1; v <= n; v++) {
                //모든 간선을 순회
                for (Node node : adjList.get(v)) {
                    if (dist[node.from] != INF) {
                        dist[node.to] = Math.min(dist[node.to], dist[node.from] + node.cost);
                    }
                }
            }
            return dist;
        }
        private List<List<Node>> initAdjList(int[][] graph, int n) {
            List<List<Node>> adjList = new ArrayList<>();

            for (int i = 0; i <= n; i ++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] edge : graph) {
                adjList.get(edge[0]).add(new Node(edge[0], edge[1], edge[2]));
            }
            return adjList;
        }

        private static class Node {
            int from;
            int to;
            int cost;

            public Node(int from, int to, int cost) {
                this.from = from;
                this.to = to;
                this.cost = cost;
            }
        }
    }
}
