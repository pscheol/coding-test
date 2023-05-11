package com.coding.programmers.level1;

import java.util.*;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(sol.solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
    static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (o1, o2) -> {
                if (o1.charAt(n) > o2.charAt(n)) {
                    return 1;
                } else if (o1.charAt(n) < o2.charAt(n)) {
                    return -1;
                } else if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                return 0;
            });
            return strings;
        }
    }
}
