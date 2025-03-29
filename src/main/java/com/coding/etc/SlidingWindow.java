package com.coding.etc;

import java.util.*;

/**
 * 문제:
 * 배열 A와 정수 K가 주어질 때, 크기가 K인 윈도우를 이동하면서 최댓값을 구하시오.
 *
 * 예제 입력:
 * val A = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
 * val K = 3
 * 출력
 * [3, 3, 5, 5, 6, 7]
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] result = new Solution().maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7}, 3);

        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n == 0 || k == 0) {
                return new int[0];
            }

            int[] result = new int[n - k + 1];
            Deque<Integer> window = new ArrayDeque<>();

            for (int i = 0; i < n; ++i) {
                while (!window.isEmpty() && window.peekFirst() <= i - k) {
                    window.pollFirst();
                }

                while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                    window.pollLast();
                }

                window.offerLast(i);

                if (i >= k - 1) {
                    result[i - k + 1] = nums[window.peekFirst()];
                }
            }
            return result;
        }
        public int[] maxSlidingWindow2_Timeout(int[] nums, int k) {
            int[] answer = new int[nums.length - k + 1];

            for (int i = 0; i <= nums.length - k; i++) {
                int max = nums[i];
                for (int j = i; j < k + i; j++) {
                    max = Math.max(max, nums[j]);
                }
                answer[i] = max;
            }
            return answer;
        }
    }
}
