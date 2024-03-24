package com.coding.programmers.level2;

public class 타겟넘버 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            return dfs(0, 0, numbers, target);
        }

        int dfs(int sum, int idx, int[] nums, int target) {
            if (idx == nums.length && sum == target) {
                return 1;
            }
            if (idx >= nums.length) {
                return 0;
            }
            return dfs(sum + nums[idx], idx + 1, nums, target) + dfs(sum - nums[idx], idx + 1, nums, target);
        }
    }
}
