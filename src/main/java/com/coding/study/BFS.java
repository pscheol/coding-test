package com.coding.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Map<String, List<String>> adjList = new HashMap<>();

        adjList.put("A", Arrays.asList("B", "C", "D"));
        adjList.put("B", Arrays.asList("A", "E"));
        adjList.put("C", Arrays.asList("A","D","E", "F"));
        adjList.put("D", Arrays.asList("A", "C", "F"));
        adjList.put("E", Arrays.asList("B", "C", "G"));
        adjList.put("F", Arrays.asList("C", "D"));
        adjList.put("G", List.of("E"));

        bfs(adjList, "A");
    }

    public static void bfs(Map<String, List<String>> adjList, String visit) {

        Queue<String> queue = new LinkedList<>();

        Set<String> seen = new HashSet<>();

        queue.add(visit);
        seen.add(visit);

        while (!queue.isEmpty()) {
            String pop = queue.poll();
            System.out.print(pop + ", ");

            for (String v : adjList.get(pop)) {
                if (!seen.contains(v)) {
                    queue.add(v);
                    seen.add(v);
                }
            }
        }
    }


}
