package com.coding.programmers.level3;

import java.util.ArrayDeque;
import java.util.Queue;

public class 경주로건설 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int result0 = sol.solution(new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0}
        });
        System.out.println(result0);

        int result1 = sol.solution(new int[][]{
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},
                {0,0,1,0,0,0,1,0},
                {0,1,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0}
        });
        System.out.println(result1);


        int result2 = sol.solution(new int[][]{
                {0,0,1,0},
                {0,0,0,0},
                {0,1,0,1},
                {1,0,0,0}
        });
        System.out.println(result2);

        int result = sol.solution(new int[][]{
                {0,0,0,0,0,0},
                {0,1,1,1,1,0},
                {0,0,1,0,0,0},
                {1,0,0,1,0,1},
                {0,1,0,0,0,1},
                {0,0,0,0,0,0}
        });
        System.out.println(result);
    }
    private static class Solution {
        private static final int[] DX = new int[] {0, -1, 0, 1}; //up, left ,down,right
        private static final int[] DY = new int[] {-1, 0, 1, 0};
        private static final int STRAIGHT = 100;
        private static final int CORNER = 500;

        public int solution(int[][] board) {
            return bfs(board);
        }

        private int bfs(int[][] board) {
            int answer = Integer.MAX_VALUE;
            int[][][] visited = new int[board.length][board[0].length][4];
            Queue<Node> deque = new ArrayDeque<>();
            
            deque.offer(new Node(0, 0, -1, 0));
            
            while (!deque.isEmpty()) {
                Node current = deque.poll();

                for (int i = 0; i < 4; i++) {
                    int nextY = current.ny + DY[i];
                    int nextX = current.nx + DX[i];

                    if (nextX < 0 || nextX >= board[0].length || nextY < 0 || nextY >= board.length) {
                        continue;
                    }

                    if (board[nextY][nextX] == 1) {
                        continue;
                    }

                    //코너 체크 금액
                    int cost = (((current.direction == -1) || (current.direction - i) % 2 == 0) ? STRAIGHT : STRAIGHT + CORNER) + current.cost;

                    if (nextX == (board[0].length -1) && (nextY == board.length - 1)) {
                        answer = Math.min(answer, cost);
                    }
                    if (visited[nextY][nextX][i] == 0 || visited[nextY][nextX][i] > cost) {
                        visited[nextY][nextX][i] = cost;
                        deque.offer(new Node(nextY, nextX, i, cost));
                    }
                }
            }
            return answer;
        }

        private static class Node {
            int ny;
            int nx;
            int direction; //이전노드의 위치값
            int cost; //비용

            public Node(int ny, int nx, int direction, int cost) {
                this.ny = ny;
                this.nx = nx;
                this.direction = direction;
                this.cost = cost;
            }
        }
    }
}
