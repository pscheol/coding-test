package com.coding.programmers.level1;

public class 숫자짝꿍 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("100","2345"));
        System.out.println(sol.solution("100","203045"));
        System.out.println(sol.solution("100","123450"));
        System.out.println(sol.solution("12321","42531"));
        System.out.println(sol.solution("5525","1255"));
    }
    private static class Solution {
        public String solution(String X, String Y) {
            StringBuilder answer = new StringBuilder();

            char[] xchs = X.toCharArray();
            char[] ychs = Y.toCharArray();

            int[] xArr = new int[10];
            int[] yArr = new int[10];

            for (char xch: xchs) {
                xArr[xch - '0']++;
            }
            for (char ych : ychs) {
                yArr[ych - '0']++;
            }

            for (int i = 9 ; i >= 0; i--) {
                if (i == 0 && answer.length() == 0 && xArr[i] > 0 && yArr[i] > 0) {
                    answer.append("0");
                } else {
                    int min = Math.min(xArr[i], yArr[i]);
                    for (int j = 0; j < min; j++) {
                        answer.append(i);
                    }
                }
            }
            String ans = answer.toString();
            if ("".equals(ans)) {
                return "-1";
            }
            if ("0".equals(ans)) {
                return "0";
            }

            return ans;
        }
    }
}
