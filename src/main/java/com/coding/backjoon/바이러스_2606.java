package com.coding.backjoon;

import java.io.*;
import java.util.*;

public class 바이러스_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer to = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(to.nextToken());
            int v = Integer.parseInt(to.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        System.out.println(solution(adjList));

    }

    public static int solution(List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        int count = -1;
        seen.add(1);
        queue.add(1);

        while(!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> adj = adjList.get(u);
            count++;
            for (Integer v : adj) {
                if (!seen.contains(v)) {
                    queue.offer(v);
                    seen.add(v);
                }
            }
        }
        return count = count == -1 ? 0 : count;
    }
}
