package com.coding.leetcode.string;


public class ValidPalindrome_125 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(" "));
        System.out.println(solution.isPalindrome("0P"));
        System.out.println(solution.isPalindrome("a."));
    }

    private static class Solution {
        public boolean isPalindrome(String s) {
            int start = 0;
            int end = s.length() -1;

            while (start < end) {
                char chS = s.charAt(start);
                char chE = s.charAt(end);

                //1. 알파벳 또는 숫자가 아니면 증가
                if (!isAlphabetic(chS) && !isDigit(chS)) {
                    start++;
                    continue;
                }
                //2. 알파벳 또는 숫자가 아니면 감소
                if (!isAlphabetic(chE) && !isDigit(chE)) {
                    end--;
                    continue;
                }
                //3. 앞뒤 알파벳 또는 숫자가 같지 않으면 false
                if (toLowerCase(chS) != toLowerCase(chE)) {
                    return false;
                }

                start++;
                end--;
            }

            return true;
        }
        private boolean isAlphabetic(char ch) {
            return isUpperCase(ch) || isLowerCase(ch);
        }
        private boolean isDigit(char ch) {
            return ('0' <= ch && ch <= '9');
        }
        private boolean isUpperCase(char ch) {
            return ('A' <= ch && ch <= 'Z');
        }
        private boolean isLowerCase(char ch) {
            return ('a' <= ch && ch <= 'z');
        }

        private char toLowerCase(char ch) {
            char result = ch;
            if (!isDigit(ch) && isUpperCase(ch)) {
                result = (char) (result + 32);
            }
            return result;
        }
    }
}
