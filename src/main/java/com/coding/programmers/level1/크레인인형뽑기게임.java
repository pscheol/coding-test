package com.coding.programmers.level1;



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
            }
            ,new int[]{1,5,3,5,1,2,1,4}
        );

        System.out.println(result);
        int result2 = sol.solution2(new int[][]{
                        {0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}
                }
                ,new int[]{1,5,3,5,1,2,1,4}
        );

        System.out.println(result2);
    }

    /**
     * 가장 위칸 부터 잡아올림
     * 바구니 가장 아래칸 부터 쌓음
     * 바구니에 연속해서 두개의 인형이 쌓이면 터트림
     * 인형이 없는 곳에서 크레인 작동시 아무일도 일어나지 않음
     */
    private static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Deque<Integer>[] deques = new ArrayDeque[board.length + 1];
            Stack<Integer> basket = new Stack<>();

            for (int i = 0; i < board.length; i++) {
                deques[i+1] = new ArrayDeque<>();
                for (int j = 0; j < board[i].length; j++) {
                    if (board[j][i] != 0) {
                        deques[i+1].addFirst(board[j][i]);
                    }
                }
            }

            for (int move : moves) {
                Deque<Integer> deque = deques[move];

                if (deque.isEmpty()) {
                    continue;
                }

                int pop = deques[move].removeLast();
                System.out.println("move="+ move + ", pop=" +pop +", basket=" + basket +", answer=" + answer);
                if (!basket.isEmpty()) {
                     if (pop == basket.peek()) {
                         basket.pop();
                         answer+=2;
                     } else {
                         basket.push(pop);
                     }
                } else {
                    basket.push(pop);
                }
            }
            return answer;
        }

        public int solution2(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for (int move : moves) {
                for (int j = 0; j < board.length; j++) {
                    if (board[j][move - 1] != 0) {
                        if (stack.isEmpty()) { //비어있을 경우
                            stack.push(board[j][move - 1]);
                        } else if (board[j][move - 1] == stack.peek()) { //두개가 같을 경우
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[j][move - 1]); //아무일도 일어나지 않음
                        }
                        board[j][move - 1] = 0; //꺼냄
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
