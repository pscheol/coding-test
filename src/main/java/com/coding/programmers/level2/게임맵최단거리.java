package com.coding.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }));


        System.out.println(sol.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        }));

        System.out.println(sol.solution(new int[][]{
                {1, 1}
        }));
    }

    private static class Solution {
        int[][] XY = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int solution(int[][] maps) {
            int answer = 0;
            boolean[][] visited = new boolean[maps.length][maps[0].length];
            int tx = maps[0].length;
            int ty = maps.length;

            return mapSearch(maps, visited, 0, 0, tx, ty);
        }

        public int mapSearch(int[][] maps, boolean[][] visited, int x, int y, int tx, int ty) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y, 1}); //x, y, cnt
            visited[y][x] = true;

            while (!queue.isEmpty()) {
                int[] dequeue = queue.poll();
                int x1 = dequeue[0];
                int y1 = dequeue[1];
                int cnt = dequeue[2];

                if (x1 == tx - 1 && y1 == ty - 1) {
                    return cnt;
                }

                for (int[] xy : XY) {
                    int x2 = x1 + xy[0];
                    int y2 = y1 + xy[1];
                    if (x2 >= 0 && x2 < tx && y2 >= 0 && y2 < ty && maps[y2][x2] == 1) {
                        if (!visited[y2][x2]) {
                            visited[y2][x2] = true;
                            queue.offer(new int[]{x2, y2, cnt + 1});
                        }
                    }
                }
            }

            return -1;
        }
    }
}
