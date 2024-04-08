package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{5,0,2,7})));

    }

    static class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> set = new TreeSet<>();

            for (int i = 0; i < numbers.length; i++) {
                for (int i1 = i + 1; i1 < numbers.length; i1++) {
                    set.add(numbers[i] + numbers[i1]);
                }
            }
            return set.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
