package com.coding.programmers.level2;

public class 점프와순간이동 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int r = sol.solution(5);
        System.out.println(r);

        int rr = sol.solution(6);
        System.out.println(rr);

        int rrr = sol.solution(5000);
        System.out.println(rrr);
    }

    private static class Solution {
        public int solution(int n) {
            int ans = 0;
            while(n > 0) {
                if (n % 2 == 1) {
                    ans++;
                }
                n /= 2;
            }
            return ans;
        }
    }
}
