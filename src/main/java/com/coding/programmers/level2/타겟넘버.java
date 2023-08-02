package com.coding.programmers.level2;

public class 타겟넘버 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static class Solution {
        int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(0, 0, numbers, target);
            return answer;
        }

        void dfs(int sum, int idx, int[] nums, int target) {
            System.out.println("dfs idx=" + idx +", sum=" + sum);
            if (idx == nums.length && sum == target) {
                answer++;
                return;
            }
            if (idx >= nums.length) {
                return;
            }

            dfs(sum + nums[idx], idx + 1, nums, target);
            dfs(sum - nums[idx], idx + 1, nums, target);

        }
    }
}
