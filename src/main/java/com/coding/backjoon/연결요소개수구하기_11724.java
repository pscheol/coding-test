package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 연결요소개수구하기_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> adjGraph = new ArrayList<>();
        for (int i = 0; i < line[0] + 1; i++) {
            adjGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < line[1]; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> a = adjGraph.get(nums[0]);
            List<Integer> b = adjGraph.get(nums[1]);

            a.add(nums[1]);
            b.add(nums[0]);
            adjGraph.set(nums[0], a);
            adjGraph.set(nums[1], b);
        }

        boolean[] visited = new boolean[line[0] + 1];

        int count = 0;
        for (int i = 1; i< line[0] + 1; i++) {
            if (!visited[i]) {
                dfs(adjGraph, visited, i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static void dfs(List<List<Integer>> adjGrap, boolean[] visited, int start) {

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int r = stack.pop();
            System.out.println("pop=" + r);
            for (int v : adjGrap.get(r)) {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.push(v);
                }
            }
        }
    }
}
