package com.coding.programmers.level2;

import java.util.Arrays;
import java.util.Map;

public class 전화번호목록 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean result = sol.solution(new String[]{"12","123","1235","567","88"});
        System.out.println(result);
    }
    private static class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);
            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i+1].startsWith(phone_book[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
