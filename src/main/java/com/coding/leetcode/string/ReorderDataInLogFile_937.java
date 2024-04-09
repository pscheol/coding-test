package com.coding.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
 *
 * There are two types of logs:
 *
 * Letter-logs: All words (except the identifier) consist of lowercase English letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 *
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 * Example 2:
 *
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 *
 * Constraints:
 *
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * All the tokens of logs[i] are separated by a single space.
 * logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 */
public class ReorderDataInLogFile_937 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        System.out.println(Arrays.toString(result));
        String[] result2 = sol.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"});
        System.out.println(Arrays.toString(result2));

        String[] result3 = sol.reorderLogFiles(new String[]{"27 85717 7", "2 y xyr fc", "52 314 99", "d 046099 0", "m azv x f", "7e apw c y", "8 hyyq z p", "6 3272401", "c otdk cl", "8 ksif m u"});
        System.out.println(Arrays.toString(result3));
    }
    private static class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String> digits = new ArrayList<>();
            List<String> letters = new ArrayList<>();

            //1. 문자열 데이터 와 숫자열 데이터 나누기
            for (String log : logs) {
                char ch = log.charAt(log.length() - 1);
                if (ch >= '0' && ch <= '9') {
                    digits.add(log);
                } else {
                    letters.add(log);
                }
            }

            letters.sort((o1, o2) -> {
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);
                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            });

            letters.addAll(digits);

            return letters.toArray(String[]::new);
        }
    }
}
