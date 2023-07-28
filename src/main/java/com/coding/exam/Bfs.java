package com.coding.exam;

import java.util.*;

public class Bfs {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2,4},
                {0, 2},
                {1,0,3},
                {2,4},
                {0,3,2}
        };
        List<List<Integer>> adjGraph = new ArrayList<>();
        adjGraph.add(0, Arrays.asList(1,2,4));
        adjGraph.add(1, Arrays.asList(0,2));
        adjGraph.add(2, Arrays.asList(1,0,3));
        adjGraph.add(3, Arrays.asList(2,4));
        adjGraph.add(4, Arrays.asList(0,3,2));



        boolean[] visited = new boolean[graph.length];

        bfs(graph, visited, 0);
        System.out.println();
        boolean[] visited1 = new boolean[adjGraph.size()];
        adjBfs(adjGraph, visited1, 0);
    }

    public static void bfs(int[][] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(start+ " ");
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int vv : graph[v]) {
                if (!visited[vv]) {
                    System.out.print(vv + " ");
                    queue.add(vv);
                    visited[vv] = true;
                }
            }
        }

    }

    public static void adjBfs(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(start+ " ");
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int vv : graph.get(v)) {
                if (!visited[vv]) {
                    System.out.print(vv + " ");
                    queue.add(vv);
                    visited[vv] = true;
                }
            }
        }

    }
}
