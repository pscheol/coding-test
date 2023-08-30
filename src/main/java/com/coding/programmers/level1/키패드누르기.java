package com.coding.programmers.level1;


public class 키패드누르기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        String result2 = sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        String result3 = sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
    private static class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder answer = new StringBuilder();
            int right = 12;
            int left = 10;

            for (int number : numbers) {
                if (number == 1 || number == 4 || number == 7) {
                    left = number;
                    answer.append("L");
                } else if (number == 3 || number == 6 || number == 9) {
                    right = number;
                    answer.append("R");
                } else {
                    int l = keyLen(left, number);
                    int r = keyLen(right, number);
                    System.out.println("Left=" + left +", right=" + right + ", num="+ number + ", KL=" + l + ", KR=" + r);

                    if (l == r) {
                        if (hand.equals("right")) {
                            right = number;
                            answer.append("R");
                        } else {
                            left = number;
                            answer.append("L");
                        }
                    } else {
                        if (l > r) {
                            right = number;
                            answer.append("R");
                        } else {
                            left = number;
                            answer.append("L");
                        }
                    }
                }
            }

            return answer.toString();
        }

        private int keyLen(int src, int number) {
            System.out.println("src=" + src + ", number=" + number);
            int hand = src == 0 ? 11 : src;
            int chkNum = number == 0 ? 11 : number;
            int check = Math.abs(hand - chkNum);
            return (check / 3) + (check % 3);
        }
    }
}
