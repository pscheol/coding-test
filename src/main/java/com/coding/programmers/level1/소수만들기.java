package com.coding.programmers.level1;

import java.util.Arrays;

public class 소수만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3, 4}));
    }


   static class Solution {
       int n = 50000;
        boolean[] isPrime = new boolean[n + 1];

        public int solution(int[] nums) {
            int answer = 0;

            Arrays.fill(isPrime, true);
            setPrime();

            for (int i = 0; i < nums.length - 2; i++) {
                for (int i1 = i + 1; i1 < nums.length - 1; i1++) {
                    for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                        if (isPrime[nums[i] + nums[i1] + nums[i2]]) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }

        public void setPrime() {
            //0,1 소수 x false
            isPrime[0] = isPrime[1] = false;

            for (int i = 2; i * i <=n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j+= i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
    }
}
