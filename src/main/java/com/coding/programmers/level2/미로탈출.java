package com.coding.programmers.level2;

import java.util.ArrayDeque;

public class 미로탈출 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
        System.out.println(result);
    }
    private static class Solution {
        private static final int[] dx = {0, 0, -1 ,1}; //up,down left, right
        private static final int[] dy = {-1, 1, 0, 0};

        public int solution(String[] maps) {
            int answer = 0;

            int N = maps.length;
            int M = maps[0].length();
            char[][] map = new char[N][M];

            //미로에 대한 배열정보 저장
            for (int i = 0; i < N; i++) {
                map[i] = maps[i].toCharArray();
            }

            //시작지점, 종료지점, 레버 위치 탐색
            Point start = null;
            Point end = null;
            Point leaver = null;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'S') {
                        start = new Point(i, j);
                    } else if (map[i][j] == 'E') {
                        end = new Point(i, j);
                    } else if (map[i][j] == 'L') {
                        leaver = new Point(i, j);
                    }
                }
            }

            //시작지점부터 레버까지의 거리
            int startToLeaver = bfs(map, N, M, start, leaver);
            //시작지점부터 레버까지의 거리
            int leaverToEnd = bfs(map, N, M, leaver, end);

            return (startToLeaver == -1 || leaverToEnd == -1) ? -1 : (startToLeaver + leaverToEnd);
        }

        private int bfs(char[][] map, int n ,int m, Point start, Point end) {
            int[][] dist = new int[n][m];
            ArrayDeque<Point> queue = new ArrayDeque<>();
            dist[start.ny][start.nx] = 1;
            queue.offer(start);

            while (!queue.isEmpty()) {
                Point dequeue = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextY = dequeue.ny + dy[i];
                    int nextX = dequeue.nx + dx[i];

                    //배열 위치에 벗어날 경우 건너뜀
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    //이미 방문했다면 건너뜀
                    if (dist[nextY][nextX] > 0) {
                        continue;
                    }

                    //막혀있으면 건너뜀
                    if (map[nextY][nextX] == 'X') {
                        continue;
                    }
                    //거리 증가
                    dist[nextY][nextX] = dist[dequeue.ny][dequeue.nx] + 1;

                    queue.offer(new Point(nextY, nextX));

                    //도착지점에 도달하면 거리 반환
                    if (nextY == end.ny && nextX == end.nx) {
                        return dist[end.ny][end.nx] - 1;
                    }
                }
            }
            return -1;
        }

        private static class Point {
            int ny;
            int nx;

            public Point(int ny, int nx) {
                this.ny = ny;
                this.nx = nx;
            }
        }
    }
}
