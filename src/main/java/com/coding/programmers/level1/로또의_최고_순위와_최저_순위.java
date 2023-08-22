package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 로또의_최고_순위와_최저_순위 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        System.out.println(Arrays.toString(result));
        int[] result1 = sol.solution2(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        System.out.println(Arrays.toString(result1));
    }
    private static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int zero = 0;
            int count = 0;
            for (int i = 0; i < lottos.length; i++) {
                if (lottos[i] == 0) {
                    zero++;
                } else {
                    for (int i1 = 0; i1 < win_nums.length; i1++) {
                        if (win_nums[i1] == lottos[i]) {
                            count++;
                            break;
                        }
                    }
                }
            }
            return new int[]{Math.min(7 - (count + zero), 6), Math.min(7 - count, 6)};
        }

        public int[] solution2(int[] lottos, int[] win_nums) {
            Set<Integer> matchSet = new HashSet<>();
            //0제외
            for (int lotto : lottos) {
                if (lotto > 0) matchSet.add(lotto);
            }

            int[] answer = {(matchSet.size() + 1), 7};

            for (int win_num : win_nums) {
                if (matchSet.contains(win_num)) {
                    answer[0]--;
                    answer[1]--;
                }
            }
            return new int[]{Math.min(answer[0], 6), Math.min(answer[1], 6)};
        }


    }
}
