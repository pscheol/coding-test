package com.coding.leetcode.string;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121));
        System.out.println(sol.isPalindrome(10));
        System.out.println(sol.isPalindrome(-121));
        System.out.println(sol.isPalindrome(1001));

    }
    private static class Solution {
        public boolean isPalindrome(int x) {
            int s = 0, n = x;
            while (n > 0) {
                s = (s * 10) + (n % 10);
                n /= 10;
            }
            return s == x;
        }
    }
}
