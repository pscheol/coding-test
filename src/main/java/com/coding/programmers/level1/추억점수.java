package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class 추억점수 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[] {"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}
                ,new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));
    }
    static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];
            Map<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < name.length; i++) {
                map.put(name[i], yearning[i]);    
            }

            for (int i = 0; i < photo.length; i++) {
                int sum = 0;
                for (int i1 = 0; i1 < photo[i].length; i1++) {
                    Integer point = map.getOrDefault(photo[i][i1], 0);
                    sum += point;
                }
                answer[i] = sum;
            }
            return answer;
        }
    }
}
