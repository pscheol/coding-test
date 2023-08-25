package com.coding.programmers.level1;

import java.util.Arrays;

/**
 * 키의 개수 1~100
 * 문자열 무작위로 배열
 * 같은 문자가 자판에 여러번 할당
 * 키 하나에 같은 문자가 여러번
 *
 * 특정문자열 작성 할 때
 * 키를 최소 몇번 눌러야 작성할 수 있는지.
 *
 * 1번부터 차례대로 할당된 문자열배열 keymap
 * 입력하기위해 담긴 문자열배열 targets
 *
 * 몇 번을 눌러야 하는지 순서대로 담아 return
 *
 * 1 1 2 5 = 9 / 1 1 1 1 = 4
 */
public class 대충만든자판 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new String[]{"ABACD", "BCEFD"},
                new String[]{"ABCD","AABB"});
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] keyLens = new int[26];
            int[] answer = new int[targets.length];
            Arrays.fill(keyLens, -1);

            for (String s : keymap) {
                char[] keys = s.toCharArray();
                for (int i = 0; i < keys.length; i++) {
                    int key = keys[i] - 65;
                    int l = i+1;

                    int len = keyLens[key];
                    if (len == -1) {
                        keyLens[key] = l;
                    } else {
                        keyLens[key] = Math.min(keyLens[key], l);
                    }
                }
            }

            for (int i = 0; i < targets.length; i++) {
                char[] ts = targets[i].toCharArray();

                for (int j = 0; j < ts.length; j++) {
                    int key = ts[j] - 65;
                    if (keyLens[key] == -1) {
                        answer[i] = -1;
                        break;
                    } else {
                        answer[i] += keyLens[key];
                    }
                }
            }
            return answer;
        }
    }
}
