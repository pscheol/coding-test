package com.coding.programmers.level1;

import java.util.*;

public class 공원산책 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new String[]{"SOO",
                                                 "OOO",
                                                 "OOO"}, new String[]{"E 2","S 2","W 1"});
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution(new String[]{"SOO",
                                                  "OXX",
                                                  "OOO"}, new String[]{"E 2","S 2","W 1"});
        System.out.println(Arrays.toString(result2));

        int[] result3 = sol.solution(new String[]{"OSO",
                                                  "OOO",
                                                  "OXO",
                                                  "OOO"}, new String[]{"E 2","S 3","W 1"});
        System.out.println(Arrays.toString(result3));

        int[] result4 = sol.solution(new String[]{"OXO",
                                                  "XSX",
                                                  "OXO"}, new String[]{"S 1", "E 1", "W 1", "N 1"}); //1.1
        System.out.println(Arrays.toString(result4));

    }

    private static class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = {0,0};
            int y = park.length;
            int x = park[0].length();

            for (int i = 0; i < park.length; i++) {
                int idx = park[i].indexOf("S");
                if (idx != -1) {
                    answer[0] = i;
                    answer[1] = idx;
                    break;
                }
            }

            for (int i = 0; i < routes.length; i++) {
                String[] route = routes[i].split(" ");
                String op = route[0];
                int n = Integer.parseInt(route[1]);

                if ("E".equals(op) && (answer[1] + n < x) && checkX(park, answer[0], answer[1], n, 1)) {
                    answer[1] += n;
                } else if ("W".equals(op) && (answer[1] - n >= 0) && checkX(park, answer[0], answer[1], n, -1)) {
                    answer[1] -= n;
                } else if ("S".equals(op) && (answer[0] + n < y) && checkY(park, answer[0], answer[1], n, 1)) {
                    answer[0] += n;
                } else if ("N".equals(op) && (answer[0] - n >= 0) && checkY(park, answer[0], answer[1], n, -1)) {
                    answer[0] -= n;
                }
            }

            return answer;
        }

        private boolean checkX(String[] park, int curY, int curX, int n, int op) {
            for (int i = 1; i <= n; i++) {
                if (park[curY].charAt(curX + (op * i)) == 'X') {
                    return false;
                }
            }
            return true;
        }
        private boolean checkY(String[] park, int curY, int curX, int n, int op) {
            for (int i = 1; i <= n; i++) {
                if (park[curY + (op * i)].charAt(curX) == 'X') {
                    return false;
                }
            }
            return true;
        }
    }
}
