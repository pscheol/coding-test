package com.coding.etc;

import java.util.HashSet;
import java.util.Set;

public class 두개의수로특정값만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,2,3,4,8}, 6));
        System.out.println(sol.solution(new int[]{2,3,5,9}, 10));
    }
    private static class Solution {
        public boolean solution(int[] arr, int target) {
            Set<Integer> set = new HashSet<>();

            for (int i : arr) {
                if (set.contains(target - i)) {
                    return true;
                }
                set.add(i);
            }
            return false;
        }
    }
}
