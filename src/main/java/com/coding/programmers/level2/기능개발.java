package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[]{93, 30, 55}, new int[]{1,30,5});
        System.out.println(Arrays.toString(result));
        int[] result2 = sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(result2));

    }
    private static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            int dist = (int) Math.ceil((double)(100 - progresses[0]) / speeds[0]);
            int count = 1;
            for (int i = 1; i < progresses.length; i++) {
                int day = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
                if (dist < day) {
                    dist = day;
                    answer.add(count);
                    count = 0;
                }
                count++;
            }
            answer.add(count);
            
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
