package com.coding.programmers.level2;

import java.util.Arrays;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution("110010101001");
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution("01110");
        System.out.println(Arrays.toString(result2));

        int[] result3 = sol.solution("1111111");
        System.out.println(Arrays.toString(result3));
    }

    /**
     * * x의 모든 0을 제거합니다.
     * x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
     */
    private static class Solution {
        public int[] solution(String s) {
            int[] answer = {0,0};
            String binary = s;

            while (!binary.equals("1")) {
                int len = binary.replaceAll("0", "").length();
                answer[0]++;
                answer[1] += (binary.length() - len);
                binary = Integer.toBinaryString(len);
            }
            return answer;
        }

        public int[] solution2(String s) {
            int[] answer = {0,0};
            String binary = s;

            while (binary.equals("1")) {
                int len = 0;
                int zeroLen = 0;
                for (char c : binary.toCharArray()) {
                    if (c == '0') {
                        zeroLen++;
                    } else {
                        len++;
                    }
                }
                answer[0] += 1;
                answer[1] += zeroLen;

                binary = Integer.toBinaryString(len);
            }
            return answer;
        }
    }
}
///01110
///111 2
///10  1
