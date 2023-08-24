package com.coding.programmers.level1;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(sol.solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(sol.solution(3, new int[]{3}, new int[]{1}));
        System.out.println(sol.solution(4, new int[]{2,3}, new int[]{3,4}));
        System.out.println(sol.solution(5, new int[]{4,2}, new int[]{3,5}));
        System.out.println(sol.solution(6, new int[]{3,4,5}, new int[]{3,4,6}));
        System.out.println(sol.solution(10, new int[]{3,4,7,9}, new int[]{2,3,8}));

        System.out.println();
        System.out.println(sol.solution2(5, new int[]{2,4}, new int[]{3}));
        System.out.println(sol.solution2(3, new int[]{3}, new int[]{1}));
        System.out.println(sol.solution2(4, new int[]{2,3}, new int[]{3,4}));
        System.out.println(sol.solution2(5, new int[]{4,2}, new int[]{3,5}));
        System.out.println(sol.solution2(6, new int[]{3,4,5}, new int[]{3,4,6}));
        System.out.println(sol.solution2(10, new int[]{3,4,7,9}, new int[]{2,3,8}));
    }
    private static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            Arrays.sort(lost);
            Arrays.sort(reserve);
            int answer = n;

            for (int i = 0 ; i < reserve.length; i++) {
                for (int j = 0; j < lost.length; j++) {
                    if (reserve[i] == lost[j]) {
                        reserve[i] = 0;
                        lost[j] = 0;
                        break;
                    }
                }
            }

            for (int r : reserve) {
                if (r == 0)
                    continue;
                for (int i = 0; i < lost.length; i++) {
                    int range = lost[i] - r;
                    if (lost[i] != 0 && (range == -1 || range == 1)) {
                        lost[i] = 0;
                        break;
                    }
                }
            }

            for (int l : lost) {
                if (l != 0) {
                    answer--;
                }
            }
            return answer;
        }

        public int solution2(int n, int[] lost, int[] reserve) {
            int[] p = new int[n+1];
            int answer = n;

            for (int l : lost) {
                p[l]--;
            }
            for (int r : reserve) {
                p[r]++;
            }

            for (int i = 1; i < p.length; i++) {
                if (p[i] != -1) {
                    continue;
                }
                if (i-1 > 0 && p[i-1] == 1) {
                    p[i]++;
                    p[i-1]--;
                } else if (i+1 < p.length && p[i+1] == 1) {
                    p[i]++;
                    p[i+1]--;
                } else {
                    answer--;
                }
            }
            return answer;
        }
    }
}
