package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{5,0,2,7})));

        System.out.println(Arrays.toString(sol.solution2(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(sol.solution2(new int[]{5,0,2,7})));
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                int d = numbers[i];
                for (int i1 = 0; i1 < numbers.length; i1++) {
                    if (i == i1) {
                        continue;
                    }
                    set.add(numbers[i1] + d);
                }
            }
            return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        }

        public int[] solution2(int[] numbers) {
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < numbers.length; i++) {
                int d = numbers[i];
                for (int i1 = i + 1; i1 < numbers.length; i1++) {
                    set.add(numbers[i1] + numbers[i]);
                }
            }
            int[] answer = new int[set.size()];
            int cnt = 0;
            for (Integer d : set) {
                answer[cnt++] = d;
            }

            return answer;
        }
    }
}
