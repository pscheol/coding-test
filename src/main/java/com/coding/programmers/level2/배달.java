package com.coding.programmers.level2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, new int[][]{
                {1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
        }, 3));
    }
    private static class Solution {
        public int solution(int N, int[][] road, int K) {
            //initialize
            List<List<Town>> adjList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
            }

            //add adjList
            for (int[] r : road) {
                adjList.get(r[0]).add(new Town(r[1], r[2]));
                adjList.get(r[1]).add(new Town(r[0], r[2]));
            }


            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Town> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(new Town(1, 0));
            dist[1] = 0;

            while (!priorityQueue.isEmpty()) {
                Town town = priorityQueue.poll();

                if (dist[town.dest] < town.time) {
                    continue;
                }

                for (Town adjTown : adjList.get(town.dest)) {
                    if (dist[adjTown.dest] > (town.time + adjTown.time)) {
                        dist[adjTown.dest] = (town.time + adjTown.time);
                        priorityQueue.add(new Town(adjTown.dest, dist[adjTown.dest]));
                    }
                }
            }

            return (int) Arrays.stream(dist).filter(d-> d != Integer.MAX_VALUE && d <= K).count();
        }
        private static class Town implements Comparable<Town> {
            int dest;
            int time;

            public Town(int dest, int time) {
                this.dest = dest;
                this.time = time;
            }

            @Override
            public int compareTo(Town o) {
                return Integer.compare(this.time, o.time);
            }
        }
    }
}
