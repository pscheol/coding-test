package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer strTo = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(strTo.nextToken());
        int m = Integer.parseInt(strTo.nextToken());
        int v = Integer.parseInt(strTo.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer to = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(to.nextToken());
            int v2 = Integer.parseInt(to.nextToken());
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        for (List<Integer> adj : adjList) {
            Collections.sort(adj);

        }

        System.out.println(solution_DFS(adjList, v));
        System.out.println(solution_BFS(adjList, v));

    }


    public static String solution_DFS(List<List<Integer>> adjList, int r) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(adjList, seen, sb, r);
        return sb.toString();
    }
    private static void dfs(List<List<Integer>> adjList, Set<Integer> seen, StringBuilder sb, int r) {
        seen.add(r);
        sb.append(r);
        sb.append(" ");

        List<Integer> adj = adjList.get(r);
        for (Integer v : adj) {
            if (!seen.contains(v)) {
                seen.add(v);
                dfs(adjList, seen, sb, v);
            }
        }
    }

    public static String solution_BFS(List<List<Integer>> adjList, int r) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        seen.add(r);
        queue.add(r);

        while(!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> adj = adjList.get(u);
            sb.append(u);
            sb.append(" ");
            for (Integer v : adj) {
                if (!seen.contains(v)) {
                    queue.offer(v);
                    seen.add(v);
                }
            }
        }
        return sb.toString();
    }
}
