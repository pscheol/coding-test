package com.coding.codility.countelements;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,3,6,4,1,2}));
        System.out.println(new Solution().solution(new int[]{1,2,3}));
        System.out.println(new Solution().solution(new int[]{-1,-3}));
    }

    private static class Solution {
        /**
         * A에서 발생하는 가장 작은 양의 정수(0보다큼)을 반환
         * @param A
         * @return
         */
        public int solution(int[] A) {
            Arrays.sort(A);
            int min = 1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == min) {
                    min++;
                }
            }
            return min;
        }
    }
}

/**
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000]. *
 */