package com.coding.programmers.level3;

import com.coding.programmers.level0.Ar;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result1 = sol.solution(new String[][] {
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
        });
        //["ICN", "JFK", "HND", "IAD"]
        System.out.println(Arrays.toString(result1));
        String[] result = sol.solution(new String[][] {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL","SFO"}
        });
        //["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        System.out.println(Arrays.toString(result));

        String[] result2 = sol.solution(new String[][]{
                {"ICN", "AAA"}, {"AAA", "ICN"}, {"ICN", "CCC"}, {"CCC", "ICN"}, {"ICN", "DDD"}, {"DDD", "AAA"}
        });

        //["ICN", "AAA", "ICN", "CCC", "ICN", "DDD", "AAA"]
        System.out.println(Arrays.toString(result2));

        String[] result3 = sol.solution(new String[][]{
                {"ICN", "D"}, {"D", "ICN"}, {"ICN", "B"}
        });

        //'ICN', 'D', 'ICN', 'B'
        System.out.println(Arrays.toString(result3));
    }
    private static class Solution {
        public String[] solution(String[][] tickets) {
            List<String> answer = new ArrayList<>();
            boolean[] visited = new boolean[tickets.length];
            dfs(0, "ICN", "ICN", tickets, visited, answer);
            answer.sort(String::compareTo);
            return answer.get(0).split(" ");
        }

        void dfs(int idx, String departure, String route, String[][] tickets, boolean[] visited, List<String> result) {
            if (idx == tickets.length) {
                result.add(route);
                return;
            }
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals(departure) && !visited[i]) {
                    visited[i] = true;
                    dfs(idx + 1, tickets[i][1], route + " " + tickets[i][1], tickets, visited, result);
                    visited[i] = false;
                }
            }
        }
    }
}
