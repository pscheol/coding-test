package com.coding.programmers.level1;

import java.util.*;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println(result);
    }

    private static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Map<String, Integer> map = new HashMap<>();

            for (String c : completion) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (String p : participant) {
                if (map.getOrDefault(p, 0) == 0) {
                    answer = p;
                    break;
                }
                map.put(p, map.get(p) - 1);
            }
            return answer;
        }
    }
}
