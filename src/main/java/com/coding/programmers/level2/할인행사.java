package com.coding.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        });
        System.out.println(result);
    }
    private static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            int window = 10;
            Map<String, Integer> wantMap = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                wantMap.put(want[i], number[i]);
            }

            for (int i = 0; i < discount.length - (window - 1); i++) {
                Map<String, Integer> discountMap = new HashMap<>();

                for (int j = i; j < i + window; j++) {
                    if (wantMap.containsKey(discount[j])) {
                        discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                    }
                }

                if (discountMap.equals(wantMap)) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
