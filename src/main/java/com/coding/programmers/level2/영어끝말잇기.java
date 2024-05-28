package com.coding.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        public int[] solution(int n, String[] words) {
            Set<String> dupSet = new HashSet<>();
            char prevWord = words[0].charAt(0);

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (dupSet.contains(words[i]) || prevWord != word.charAt(0)) {
                    return new int[]{(i % n) + 1, (i / n) + 1};
                }

                dupSet.add(words[i]);
                prevWord = word.charAt(word.length() - 1);

            }

            return new int[]{0,0};
        }
    }
}
