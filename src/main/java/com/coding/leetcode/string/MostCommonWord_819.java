package com.coding.leetcode.string;

import java.util.*;

/**
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Example 2:
 *
 * Input: paragraph = "a.", banned = []
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= paragraph.length <= 1000
 * paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
 * 0 <= banned.length <= 100
 * 1 <= banned[i].length <= 10
 * banned[i] consists of only lowercase English letters.
 */
public class MostCommonWord_819 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result1 = sol.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        String result2 = sol.mostCommonWord("a.", new String[]{});
        String result3 = sol.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        String result4 = sol.mostCommonWord("Bob", new String[]{});


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
    private static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
            Map<String, Integer> bannedWord = new LinkedHashMap<>();
            int max = 0;
            String answer = "";

            StringTokenizer token = new StringTokenizer(paragraph.toLowerCase(), " !?',;.");

            while (token.hasMoreTokens()) {
                String s = token.nextToken();
                if (!bannedSet.contains(s)) {
                    bannedWord.put(s, bannedWord.getOrDefault(s, 0) + 1);
                    int cnt = bannedWord.get(s);
                    if (cnt > max) {
                        max = cnt;
                        answer = s;
                    }
                }
            }
            return answer;
        }

    }
}
