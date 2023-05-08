package com.coding.programmers.level1;

public class 최소직사각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{ {60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution.solution2(new int[][]{ {60, 50}, {30, 70}, {60, 30}, {80, 40}}));

    }

    static class Solution {
        public int solution(int[][] sizes) {
            int wMax = 0;
            int hMax = 0;
            for (int i = 0; i < sizes.length; i++) {
                int w = sizes[i][0];
                int h = sizes[i][1];
                if (w > h) {
                    wMax = Math.max(w, wMax);
                    hMax = Math.max(h, hMax);
                } else {
                    wMax = Math.max(h, wMax);
                    hMax = Math.max(w, hMax);
                }
            }
            return wMax * hMax;
        }
        public int solution2(int[][] sizes) {
            int wMax = 0;
            int hMax = 0;
            for (int[] size : sizes) {
                wMax = Math.max(wMax, Math.max(size[0], size[1]));
                hMax = Math.max(hMax, Math.min(size[0], size[1]));
            }
            return wMax * hMax;
        }
    }
}
