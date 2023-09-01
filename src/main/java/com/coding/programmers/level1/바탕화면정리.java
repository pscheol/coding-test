package com.coding.programmers.level1;

import java.util.Arrays;

public class 바탕화면정리 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] result2 = sol.solution(new String[]{".#...", "..#..", "...#."});
        System.out.println(Arrays.toString(result2));
        int[] result = sol.solution(new String[]{"..........",
                                                 ".....#....",
                                                 "......##..",
                                                 "...##.....",
                                                 "....#....."});
        System.out.println(Arrays.toString(result));

    }
    private static class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
            for (int i = 0; i < wallpaper.length; i++) {
                int f = wallpaper[i].indexOf("#");
                int l = wallpaper[i].lastIndexOf("#");

                if (f != -1) {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], f);
                }
                if (l != -1) {
                    answer[2] = Math.max(answer[2], i+1);
                    answer[3] = Math.max(answer[3], l+1);
                }
            }
            return answer;
        }
    }
}
