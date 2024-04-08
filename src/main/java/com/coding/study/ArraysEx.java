package com.coding.study;

import java.util.Arrays;
import java.util.Collections;

public class ArraysEx {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{4,2,2,1,3,4})));
    }
    private static class Solution {
        public int[] solution(int[] arr) {
            return Arrays.stream(arr).boxed()
                    .distinct()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(v -> v)
                    .toArray();
        }
    }
}
