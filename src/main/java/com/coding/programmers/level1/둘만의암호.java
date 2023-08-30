package com.coding.programmers.level1;


public class 둘만의암호 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("bcdefghijklmnopqrstuvwxyz", "a", 1));
        System.out.println(sol.solution("aukks", "wbqd", 5));
        System.out.println(sol.solution("y", "baz", 1));


        System.out.println(sol.solution2("bcdefghijklmnopqrstuvwxyz", "a", 1));
        System.out.println(sol.solution2("aukks", "wbqd", 5));
        System.out.println(sol.solution2("y", "baz", 1));

    }
    private static class Solution {

        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
            char[] sChars = s.toCharArray();
            char[] skipChars = skip.toCharArray();
            StringBuilder alphabet = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                alphabet.append((char)('a' + i));
            }

            for (char ch : skipChars) {
                int key = alphabet.indexOf(String.valueOf(ch));
                alphabet.deleteCharAt(key);
            }

            for (char ch : sChars) {
                int key = alphabet.indexOf(String.valueOf(ch)) + index;
                answer.append(alphabet.charAt((key % alphabet.length())));
            }

            return answer.toString();
        }

        public String solution2(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();

            for (char c : s.toCharArray()) {
                char tmp = c;
                int idx = 0;
                while (idx < index) {
                    tmp = tmp == 'z' ? 'a' : (char) (tmp + 1);
                    if (!skip.contains(String.valueOf(tmp))) {
                        idx += 1;
                    }
                }
                answer.append(tmp);
            }
            return answer.toString();
        }
    }


}
