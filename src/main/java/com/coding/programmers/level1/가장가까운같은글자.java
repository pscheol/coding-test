package com.coding.programmers.level1;

import java.util.*;

public class 가장가까운같은글자 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("banana")));
        System.out.println(Arrays.toString(sol.solution("foobar")));
    }
    static class Solution {
        public int[] solution(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int[] answer = new int[s.length()];

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Integer key = map.get(chars[i]);
                if (key == null) {
                    answer[i] = -1;
                    map.put(chars[i], i);
                } else {
                    answer[i] = i - key;
                    map.put(chars[i], i);
                }
            }
            return answer;
        }
    }
}
