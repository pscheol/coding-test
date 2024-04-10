package com.coding.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution sol = new Solution();
        int result = sol.longestPalindrome(s);
        System.out.println(result);

        System.out.println(sol.longestPalindrome("abccccdd"));
        System.out.println(sol.longestPalindrome("a"));
        System.out.println(sol.longestPalindrome("cccadd"));

    }

    private static class Solution {
        public int longestPalindrome(String s) {
            //ascii 128
            int[] countArr = new int[128];

            //counting
            for (char c : s.toCharArray()) {
                countArr[c]++;
            }
            int answer = 0;

            for (int count : countArr) {
                answer += (2 * (count / 2));
                if (answer % 2 == 0 && count % 2 == 1) {
                    answer++;
                }
            }
            return answer;
        }
        public int longestPalindrome2(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0 ) + 1);
            }

            for (Integer v : map.values()) {
                answer += (2 * (v / 2));
                if (answer % 2 == 0 && v % 2 == 1) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
