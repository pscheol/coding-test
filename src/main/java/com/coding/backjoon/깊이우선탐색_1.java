package com.coding.backjoon;

import java.io.*;
import java.util.*;

public class 깊이우선탐색_1 {
    static int[] visited;
    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strTo =  new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(strTo.nextToken());
        int m = Integer.parseInt(strTo.nextToken());
        int r = Integer.parseInt(strTo.nextToken());

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer subStrTo =  new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(subStrTo.nextToken());
            int v = Integer.parseInt(subStrTo.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        for (ArrayList<Integer> adj : adjList) {
            Collections.sort(adj);
        }

        dfs(r);
        

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");

        }
        bw.flush();
    }


    public static void dfs(int r) {
        visited[r] = cnt;
        List<Integer> adj = adjList.get(r);
        for (Integer v : adj) {
            if (visited[v] == 0) {
                cnt++;
                dfs(v);
            }
        }
    }
}
