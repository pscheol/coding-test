package com.coding.backjoon;

import java.io.*;
import java.util.*;

public class 깊이우선탐색_2_24480 {
    private static final ArrayList<ArrayList<Integer>> ADJ_LIST = new ArrayList<>();
    private static int[] visited;
    private static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(strToken.nextToken()); //vertex N
        int m = Integer.parseInt(strToken.nextToken()); //edge M
        int r = Integer.parseInt(strToken.nextToken()); //start R

        visited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ADJ_LIST.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer subStrToken = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(subStrToken.nextToken());
            int v = Integer.parseInt(subStrToken.nextToken());
            ADJ_LIST.get(u).add(v);
            ADJ_LIST.get(v).add(u);
        }

        for (ArrayList<Integer> adj : ADJ_LIST) {
            adj.sort(Collections.reverseOrder());
        }


        dfs(r);

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
    }

    private static void dfs(int r) {
        visited[r] = cnt;
        List<Integer> adj = ADJ_LIST.get(r);
        for (Integer v : adj) {
            if (visited[v] == 0) {
                cnt++;
                dfs(v);
            }
        }

    }
}
