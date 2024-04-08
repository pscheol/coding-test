package com.coding.programmers.level2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 방문_길이 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("ULURRDLLU"));
        System.out.println(sol.solution("LULLLLLLU"));

        System.out.println(sol.solution(""));
    }

    private static class Solution {
        //x ,y
        private static final Map<Character, int[]> MOVE = Map.of('U', new int[]{0, 1},
                        'D', new int[]{0, -1}, 'R', new int[]{1, 0}, 'L', new int[]{-1, 0});

        public int solution(String dirs) {
            int x = 5, y = 5;
            Set<String> dupSet = new HashSet<>();
            for (int i = 0; i < dirs.length(); i++) {
                int[] move = MOVE.get(dirs.charAt(i));
                int nx = x + move[0];
                int ny = y + move[1];

                //1. 범위를 초과했는지 체크
                if (!((nx >= 0 && nx <= 10) && (ny >= 0 && ny <= 10))) {
                    continue;
                }
                //거리등록
                dupSet.add(String.format("%d,%d <> %d, %d", nx, ny, x, y));
                dupSet.add(String.format("%d,%d <> %d, %d", x, y, nx, ny));
                x = nx;
                y = ny;
            }

            return dupSet.size() / 2;
        }
    }
}
