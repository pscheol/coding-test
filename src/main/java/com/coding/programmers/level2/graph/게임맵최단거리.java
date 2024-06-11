package com.coding.programmers.level2.graph;

import java.util.*;

/**
 * 도착지 (n.m)에 도달하면 최적 거리 값을 리턴
 * 그렇지 않으면 -1 리턴
 * bfs 이용
 * [1, 0, 9, 10, 11]
 * [2, 0, 8, 0, 10]
 * [3, 0, 7, 8, 9]
 * [4, 5, 6, 0, 10]
 * [0, 0, 0, 0, 11]
 * 11
 * Big O(n * m)
 */
public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        Solution sol = new Solution();
        System.out.println(sol.solution(map));
        int[][] map2 = new int[][] {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        };
        System.out.println(sol.solution(map2));
    }

    private static class Solution {
        private static final int[][] MOVE = {
                {1, 0}, //up
                {-1, 0}, //down
                {0, -1}, //left
                {0, 1}, //right
        };
        public int solution(int[][] maps) {
            //map의 크기
            int n = maps.length;
            int m = maps[0].length;

            Queue<Node> queue = new ArrayDeque<>();
            int[][] dist = new int[n][m];

            queue.add(new Node(0, 0));
            dist[0][0] = 1;

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                for (int[] move : MOVE) {
                    int vn = node.v + move[0];
                    int em = node.e + move[1];

                    //범위를 벗어날 경우
                    if (isOutOfIndex(n, m, vn, em))
                        continue;

                    //벽일 경우 건너뜀
                    if (maps[vn][em] == 0) {
                        continue;
                    }

                    if (dist[vn][em] == 0) {
                        Node newNode = new Node(vn, em);
                        queue.offer(newNode);
                        dist[vn][em] = dist[node.v][node.e] + 1;
                    }
                }
            }
            return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
        }

        private boolean isOutOfIndex(int n, int m, int vn, int em) {
            if (vn < 0 || em < 0 || vn >= n || em >= m) {
                return true;
            }
            return false;
        }

        private static class Node {
            int v;
            int e;

            public Node(int v, int e) {
                this.v = v;
                this.e = e;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return v == node.v && e == node.e;
            }

            @Override
            public int hashCode() {
                return Objects.hash(v, e);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "v=" + v +
                        ", e=" + e +
                        '}';
            }
        }
    }
}
