package com.coding.exam;


import java.util.Stack;

public class Dfs {
    public static void main(String[] args) {
        int[][] graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        boolean[] visited = new boolean[9];
        dfs(graph, visited, 1);
        System.out.println();
        stackDfs(graph, 1);
        System.out.println();
    }

    public static void dfs(int[][] graph, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " -> ");
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }
    public static void stackDfs(int[][] graph, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[9];
        stack.push(start);
        visited[start] = true;

        // 스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()) {

            // 스택에서 하나를 꺼냅니다.
            int v = stack.pop();


            // 방문 노드 출력
            System.out.print(v + " -> ");

            // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
            for (int i : graph[v]) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

    }
}
