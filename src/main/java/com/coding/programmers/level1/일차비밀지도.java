package com.coding.programmers.level1;

import java.util.Arrays;

public class 일차비밀지도 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result1 = sol.solution(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28});
        String[] result11 = sol.solution2(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28});
        String[] result2 = sol.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
        String[] result22 = sol.solution2(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result11));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result22));
    }
    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                String a1 = String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr1[i])));
                String a2 = String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr2[i])));
                char[] a1s = a1.toCharArray();
                char[] a2s = a2.toCharArray();
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    result.append(a1s[j] == '1' || a2s[j] == '1' ? "#" : " ");
                }
                answer[i] = result.toString();
            }
            return answer;
        }

        public String[] solution2(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                String b = Integer.toBinaryString(arr1[i] | arr2[i]);
                b = "0".repeat(n - b.length()) + b;
                StringBuilder sb = new StringBuilder();
                for (char c : b.toCharArray()) {
                    sb.append(c == '1' ? '#' : ' ');
                }
                answer[i] = sb.toString();
            }
            return answer;
        }
    }
}
