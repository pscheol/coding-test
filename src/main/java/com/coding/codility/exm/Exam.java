package com.coding.codility.exm;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(1000000000);
        System.out.println();
        sol.solution(1000000001);
        System.out.println();
        sol.solution(123445);
        System.out.println();
        sol.solution(54321);
        sol.solution(111110000);
        System.out.println();
        sol.solution(1);
        System.out.println();
        sol.solution(54321);

        Solution2 sol2 = new Solution2();
        System.out.println(sol2.solution(4, new int[]{1,2,4,4,3}, new int[]{2,3,1,3,1}));
        System.out.println(sol2.solution(4, new int[]{1, 2, 1, 3}, new int[]{2, 4, 3, 4}));

        Solution3 sol3 = new Solution3();
        System.out.println(sol3.solution(2, "1A 2F 1C"));
        System.out.println(sol3.solution(1, ""));
        System.out.println(sol3.solution(50, "1A 3C 2B 20G 5A 50A"));
    }
    private static class Solution {
        public void solution(int N) {
            while (N > 0) {
                int enable_print = N % 10;
                if (enable_print == 0 && N % 10 != 0) {
                    enable_print = 1;
                }
                else {
                    System.out.print(N % 10);
                }
                N = N / 10;
            }
        }
    }

    private static class Solution2 {
        public boolean solution(int N, int[] A, int[] B) {

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new LinkedList<>());
            }

            for (int i = 0; i < A.length; i++) {
                int from = A[i];
                int to = B[i];
                adjList.get(from).add(to);
                adjList.get(to).add(from);
            }


            return bfs(adjList, 1, N);
        }
        public static boolean bfs(List<List<Integer>> adjList, int v, int n) {
            Set<Integer> check = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            int count = 1;
            boolean result = false;
            int vertex = 0;
            check.add(v);
            queue.offer(v);

            while (!queue.isEmpty()) {
                //4. queue에서 정점 v 삭제
                vertex = queue.poll();
                if (vertex == count) {
                    if (count == n) {
                        result = true;
                        break;
                    }
                    count++;
                } else {
                    break;
                }

                List<Integer> adj = adjList.get(vertex);
                for (Integer vv : adj) {
                    if (!check.contains(vv)) {
                        queue.offer(vv);
                        check.add(vv);
                        break;
                    }
                }
            }
            return result;
        }
    }

    private static class Solution3 {
        public int solution(int N, String S) {
            int answer = 0;
            boolean[][] check = init(S.split(" "), N);

            for (int i = 1; i <= N; i++) {
                int count = 4;
                for (int i1 = 2; i1 < check[i].length -1; i1++) {
                    if (!check[i][i1] && !check[i][i1 + 1]) {
                        count--;
                    }
                    if (count == 0){
                        answer++;
                        count = 4;
                    }
                }
            }
            return answer;
        }

        private boolean[][] init(String[] seat, int N) {
            boolean[][] arr = new boolean[N + 1][10 + 1];
            for (String s : seat) {
                String[] r = s.split("");
                if (r.length >= 2) {
                    StringBuilder row = new StringBuilder();
                    StringBuilder col = new StringBuilder();
                    for (String s1 : r) {
                        if (Character.isDigit(s1.charAt(0))) {
                            row.append(s1);
                        } else {
                            col.append(s1);
                        }
                    }
                    if (row.length() > 0 && col.length() > 0) {
                        arr[Integer.parseInt(row.toString())][parse(col.toString())] = true;
                    }
                }
            }
            return arr;
        }

        private int parse(String s) {
            int result = 1;
            switch (s) {
                case "A":
                    result = 1;
                    break;
                case "B":
                    result = 2;
                    break;
                case "C":
                    result = 3;
                    break;
                case "D":
                    result = 4;
                    break;
                case "E":
                    result = 5;
                    break;
                case "F":
                    result = 6;
                    break;
                case "G":
                    result = 7;
                    break;
                case "H":
                    result = 8;
                    break;
                case "J":
                    result = 9;
                    break;
                case "K":
                    result = 10;
                    break;
            }
            return result;
        }
    }
}
