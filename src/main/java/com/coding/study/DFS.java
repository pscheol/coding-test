package com.coding.study;

import java.util.*;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Map<String, List<String>> adjList = new HashMap<>();

        adjList.put("A", Arrays.asList("D", "C", "B"));
        adjList.put("B", Arrays.asList("E", "A"));
        adjList.put("C", Arrays.asList("F", "E", "D", "A"));
        adjList.put("D", Arrays.asList("F", "C", "A"));
        adjList.put("E", Arrays.asList("G", "C", "B"));
        adjList.put("F", Arrays.asList("D", "C"));
        adjList.put("G", List.of("E"));

        dfs(adjList, "A");
    }

    public static void dfs(Map<String, List<String>> adjList, String visit) {

        Stack<String> stack = new Stack<>();
        Set<String> seen = new HashSet<>();

        stack.push(visit);
        seen.add(visit);

        while (!stack.isEmpty()) {
            System.out.println("stack:" +stack);
            String pop = stack.pop();
            System.out.print(pop + ", ");

            for (String v : adjList.get(pop)) {
                if (!seen.contains(v)) {
                    stack.push(v);
                    seen.add(v);
                }
            }
        }
    }

    public static void bfs(Map<String, List<String>> adjList, String visit) {

    }
}
