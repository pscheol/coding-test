package com.coding.programmers.level1;


public class 키패드누르기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(result);
    }
    private static class Solution {
        private static final int[] KEYPAD = {4,1,1,1,2,2,2,3,3,3};
        public String solution(int[] numbers, String hand) {
            StringBuilder answer = new StringBuilder();
            int right = -1;
            int left = -1;

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

        private int keyLen(int num, int point) {
            System.out.println("pint=" + point + ", num=" + num);
            int sum = KEYPAD[num];
            if (num != 2 && num != 5 && num != 8 && num != 0) {
                sum += 1;
            }
            int result = Math.abs(KEYPAD[point] - sum);
            return result == 0 ? KEYPAD[point] : result;
        }
    }
}
