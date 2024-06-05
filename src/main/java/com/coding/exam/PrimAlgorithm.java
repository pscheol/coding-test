package com.coding.exam;

import java.util.*;

public class PrimAlgorithm {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(4, new int[][] {
                {0,1,1},
                {0,2,2},
                {1,2,5},
                {1,3,1},
                {2,3,8}
        });
        System.out.println(result);

        int result2 = sol.solution(5, new int[][] {
                {1,3,3},
                {1,4,8},
                {4,5,9},
                {1,2,10},
                {2,5,14}
        });
        System.out.println(result2);
    }
    private static class Solution {
        public int solution(int n, int[][] costs) {
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] cost : costs) {
                graph.get(cost[0]).add(new Edge(cost[0], cost[2]));
                graph.get(cost[0]).add(new Edge(cost[1], cost[2]));
            }

            return prim(graph, costs[0][0]);
        }
        public int prim(List<List<Edge>> graph, int start) {
            Set<Integer> visited = new HashSet<>();

            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
            priorityQueue.offer(new Edge(start, 0));

            int costs = 0;
            while (!priorityQueue.isEmpty()) { //우선순위 큐가 빌 때까지 반복

                Edge u = priorityQueue.poll();

                if (visited.contains(u.vertex)) //방문했다면 건너뜀
                    continue;;

                visited.add(u.vertex); // 방문하지 않았다면 vertex 방문했다고 표시
                costs += u.cost; //가중치 증가

                for (Edge edge : graph.get(u.vertex)) { //u.vertex 의 인접 정점 추가
                    if (!visited.contains(edge.vertex)) {
                        priorityQueue.add(edge);
                    }
                }
            }
            return costs;
        }
        private static class Edge implements Comparable<Edge> {
            int vertex;
            int cost;

            public Edge(int vertex, int cost) {
                this.vertex = vertex;
                this.cost = cost;
            }

            @Override
            public int compareTo(Edge o) {
                return Integer.compare(cost, o.cost);
            }

            @Override
            public String toString() {
                return "Edge{" +
                        "vertex=" + vertex +
                        ", cost=" + cost +
                        '}';
            }
        }
    }

}
