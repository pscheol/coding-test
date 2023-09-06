package com.coding.programmers.level2;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result1 = sol.solution("3people unFollowed me");
        System.out.println(result1);
        String result2 = sol.solution("for the last week");
        System.out.println(result2);

        String result3 = sol.solution("for The last week");
        System.out.println(result3);

    }
    private static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();
            String[] split = s.toLowerCase().split("");
            boolean isUpper = true;
            for (String str : split) {
                answer.append(isUpper ? str.toUpperCase() : str);
                System.out.println(answer.toString());
                isUpper = str.equals(" ");
            }

            return answer.toString();
        }
    }

    public String solution2(String s) {
        StringBuilder answer = new StringBuilder();

        boolean isUpper = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                isUpper = false;
                answer.append(ch);
            } else if (!isUpper && !(ch >= '0' && ch <= '9')) {
                isUpper = true;
                char append = ch;
                 if (ch >= 'a' && ch <='z') {
                     append = (char)(ch - 32);
                 }
                answer.append(append);
            } else {
                isUpper = true;
                char append = ch;
                if ((ch >= 'A' && ch <='Z')) {
                    append = (char)(ch + 32);
                }
                answer.append(append);
            }
        }
        return answer.toString();
    }
}
