package com.coding.programmers.level1;

public class 문자열_나누기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("banana"));
        System.out.println(sol.solution("abracadabra"));
        System.out.println(sol.solution("aaabbaccccabba"));

        System.out.println(sol.solution2("banana"));
        System.out.println(sol.solution2("abracadabra"));
        System.out.println(sol.solution2("aaabbaccccabba"));

    }

    private static class Solution {
        public int solution(String s) {
            int answer = 0;
            int cnt = 0;
            int compare = 0;
            char ch = s.charAt(0);

            for (int i = 0; i < s.length(); i++) {
                char nch = s.charAt(i);

                if (ch == nch) {
                    cnt++;
                } else { // (ch != nch)
                    compare++;
                }

                if (cnt == compare && ch != nch) {
                    cnt = 0;
                    compare = 0;
                    if (i+1 != s.length()) {
                        ch = s.charAt(i+1);
                    }
                    answer++;
                }
            }
            if (cnt != 0 || compare != 0) {
                answer++;
            }
            return answer;
        }

        public int solution2(String s) {
            int answer = 0;
            int cnt = 0;
            int compare = 0;
            char target = '0';

            for (char ch : s.toCharArray()) {
                if (target == '0') {
                    target = ch;
                    cnt++;
                    answer++;
                } else if (target == ch) {
                    cnt++;
                } else {
                    compare++;
                }
                if (cnt == compare) {
                    target = '0';
                    cnt = 0;
                    compare = 0;
                }
            }
            return answer;
        }
    }
}
