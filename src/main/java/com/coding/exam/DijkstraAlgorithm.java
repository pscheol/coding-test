package com.coding.exam;

import java.util.*;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[][] {
                {0,1,9},
                {0,2,3},
                {1,0,5},
                {2,1,1}
        }, 0, 3);
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution(new int[][] {
                {0,1,1},
                {1,2,5},
                {2,3,1}
        }, 0, 4);
        System.out.println(Arrays.toString(result2));
    }

    private static class Solution {
        public int[] solution(int[][] graph, int start, int n) {
            return dijkstra(start, n, initAdjList(graph, n));
        }

        private List<List<Node>> initAdjList(int[][] graph, int n) {
            List<List<Node>> adjList = new ArrayList<>(n);

            //인접리스트 초기화
            for (int i = 0; i < n; i ++) {
                adjList.add(new ArrayList<>());
            }

            //graph 정보 인접 리스트로 저장(단방향)
            for (int[] edge : graph) {
                adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            }
            return adjList;
        }

        private int[] dijkstra(int start, int n, List<List<Node>> adjList) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE); //INF 로 초기화

            //시작 위치 0으로 초기화
            dist[start] = 0;

            //우선순위 큐를 생성하고 시작 노드를 삽입
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
            priorityQueue.add(new Node(start, 0));

            while(!priorityQueue.isEmpty()) {
                //거리가 가장 짧은 노드를 dequeue
                Node now = priorityQueue.poll();

                //현재노드의 거리 값이 큐에서 거리 값보다 크면, 해당 노드는 이미 방문한 것으로 무시
                if (dist[now.dest] < now.cost) {
                    continue;
                }

                //현재 노드와 인접한 노드들의 거리 값을 계산하여 업데이트
                for (Node next : adjList.get(now.dest)) {
                    //기존에 발견했던 거리보다 더 짧은 거리를 발견했다면 거리 값을 갱신하고 큐에 넣음
                    if (dist[next.dest] > now.cost + next.cost) {
                        dist[next.dest] = now.cost + next.cost;
                        priorityQueue.add(new Node(next.dest, dist[next.dest]));
                    }
                }
            }
            return dist;
        }

        private static class Node {
            int dest;
            int cost;

            public Node(int dest, int cost) {
                this.dest = dest;
                this.cost = cost;
            }
        }
    }
}
