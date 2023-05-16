package com.coding.programmers.level1;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}
                , new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));

    }
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int i = 0; i < commands.length; i++) {
                int[] command = commands[i];
                int s = command[0];
                int e = command[1];
                int k = command[2];
                int c = 0;
                int[] data = new int[(e-s) + 1];
                for (int j = s - 1; j < e; j++) {
                    data[c++] = array[j];
                }
                Arrays.sort(data);
                answer[i] = data[k-1];
            }

            return answer;
        }
        public int[] solution2(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int i = 0; i < commands.length; i++) {
                int[] data = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(data);
                answer[i] = data[commands[i][2]-1];
            }

            return answer;
        }
    }
}
