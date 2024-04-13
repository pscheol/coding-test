package com.coding.programmers.level2.stack;

import java.util.Arrays;
import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
        System.out.println(result);
        String result2 = sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});
        System.out.println(result2);

    }

    private static class Solution {
        /**
         * n : 행 개수
         * k : 선택된 위치
         * cmd : 명령어담긴 문자 배열
         *
         * @param n
         * @param k
         * @param cmd
         * @return
         */
        public String solution(int n, int k, String[] cmd) {

            Stack<Integer> deleted = new Stack<>();
            int[] up = new int[n + 2];
            int[] down = new int[n + 2];

            for (int i = 0; i < n + 2; i++) {
                up[i] = i - 1;
                down[i] = i + 1;
            }


            int cur = k + 1;

            for (String s : cmd) {
                String[] split = s.split(" ");
                String move = split[0];
                if ("C".equals(move)) { //delete
                    deleted.push(cur);
                    up[down[cur]] = up[cur];
                    down[up[cur]] = down[cur];
                    cur = n < down[cur] ? up[cur] : down[cur];
                } else if ("Z".equals(move) && !deleted.isEmpty()) { //undo
                    int undoRow = deleted.pop();
                    down[up[undoRow]] = undoRow;
                    up[down[undoRow]] = undoRow;
                } else { //U or D
                    int moveRow = Integer.parseInt(split[1]);
                    for (int i = 0; i < moveRow; i++) {
                        cur = "U".equals(move) ? up[cur] : down[cur];
                    }

                }
            }

            char[] answer = new char[n];
            Arrays.fill(answer, 'O');
            while (!deleted.isEmpty()) {
                answer[deleted.pop() - 1] = 'X';
            }


            return new String(answer);
        }
    }
}
