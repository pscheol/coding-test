package com.coding.leetcode.string;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 */
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
