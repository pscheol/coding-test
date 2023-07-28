package com.coding.programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 다트게임 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("1D#2S*3S");
    }

    static class Solution {
        public int solution(String dartResult) {
            Map<Character, Integer> bonus = new HashMap<>();
            bonus.put('S', 1);
            bonus.put('D', 2);
            bonus.put('T', 3);
            Map<Character, Integer> option = new HashMap<>();
            option.put('#', -1);
            option.put('*', 2);
            Stack<String> stack = new Stack<>();

            int answer = 0;

            char[] chars = dartResult.toCharArray();
            boolean isDup = false;
            int pow = 0;
            StringBuilder num = new StringBuilder("0");
            for (int i = 0; i < chars.length; i++) {
                char data = chars[i];
                if (data >= '0' && data <= '9') {
                    num.append(data);
                } else if (bonus.containsKey(data)) {
                    pow = (int) Math.pow(Integer.parseInt(num.toString()), bonus.get(data));
                } else if (option.containsKey(data)) {
                    int opt = option.get(data);
                    answer = answer * opt + pow * opt;
                }
            }


            //1D#2S*3S  1^1 * (-1) * 2^1 * 2 + 3^1
            //1S*2T*3S 1^1 * (2) * 2+ 2 * 2 + 3^1
            //1D2S#10S 1^2 + 2^1 * (-1) + 10^1
            return answer;
        }
    }
}
