package com.coding.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 다트게임 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("1D2S#10S"));
    }

    static class Solution {
        public int solution(String dartResult) {
            Map<Character, Integer> bonus = new HashMap<>();
            bonus.put('S', 1);
            bonus.put('D', 2);
            bonus.put('T', 3);

            char[] chars = dartResult.toCharArray();
            int[] darts = new int[3];
            int idx = 0;

            for (int i = 0 ; i < chars.length; i++) {
                char data = chars[i];
                if (data >= '0' && data <= '9') { //숫자
                    darts[idx] = data - '0';
                    if (chars.length > i && (chars[i+1] >= '0' && chars[i+1] <= '9')) {
                        darts[idx] = (darts[idx] * 10) + (chars[i+1] - '0');
                        i++;
                    }
                } else if (bonus.containsKey(data)) { // 문자
                    int point = darts[idx];
                    darts[idx++] = (int) Math.pow(point, bonus.get(data));
                } else {
                    if (data == '*') {
                        darts[idx-1] *= 2;
                        if (idx - 2 >= 0) {
                            darts[idx - 2] *= 2;
                        }
                    } else {
                        darts[idx-1] *= -1;
                    }
                }
            }

            return darts[0] + darts[1] + darts[2];
        }
    }
}
