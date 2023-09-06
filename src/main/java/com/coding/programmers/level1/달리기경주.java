package com.coding.programmers.level1;

import java.util.*;

public class 달리기경주 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> pMap = new LinkedHashMap<>();

            for (int i = 0; i < players.length; i++) {
                pMap.put(players[i], i);
            }
            for (String calling : callings) {
                int idx = pMap.get(calling);
                int moveIdx = Math.max(idx - 1, 0);
                String pre = players[moveIdx];
                pMap.put(calling, moveIdx);
                pMap.put(pre, idx);
                players[moveIdx] = calling;
                players[idx] = pre;
            }

            return players;
        }

        /**
         * 시간초과*
         * @param players
         * @param callings
         * @return
         */
        public String[] solution1(String[] players, String[] callings) {
            List<String> list = new LinkedList<>(Arrays.asList(players));

            for (String calling : callings) {
                int callIdx = list.indexOf(calling);
                int preIdx = callIdx - 1;
                String call =  list.get(callIdx);
                String pre =  list.get(preIdx);
                list.set(preIdx, call);
                list.set(callIdx, pre);
            }
            return list.toArray(new String[players.length]);
        }
    }
}
