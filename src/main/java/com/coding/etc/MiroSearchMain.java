package com.coding.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2178 : 미로탐색
 */
public class MiroSearchMain {
    private static int[][] table;
    private static int[][] dist;
    final static int[][] PATH = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] splitnm = in.readLine().split(" ");
        int n = Integer.parseInt(splitnm[0]);
        int m = Integer.parseInt(splitnm[1]);

        table = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] splitLine = in.readLine().split("");
            for (int j = 0; j < splitLine.length; j++) {
                table[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        bfs(n, m);
        System.out.println(dist[n - 1][m - 1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%2d ", dist[i][j]);
            }
            System.out.println();
        }
        in.close();
    }

    public static void bfs(int n, int m) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + PATH[k][0];
                int ny = y + PATH[k][1];
                if (0 <= nx && n > nx && 0 <= ny && m > ny) {
                    if (table[nx][ny] == 1 && dist[nx][ny] == 0) {
                        queue.offer(new Edge(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }
}
