package com.coding.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(sol.solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));

    }
    private static class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> clothesMap = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1],1) + 1);
            }

            return clothesMap.values().stream().reduce(1, (a, b) -> a * b) - 1;
        }
    }
}
