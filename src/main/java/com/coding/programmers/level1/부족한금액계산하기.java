package com.coding.programmers.level1;

public class 부족한금액계산하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, 20, 4));
        System.out.println(sol.solution2(3, 20, 4));
    }
    static class Solution {
        public long solution(int price, int money, int count) {
            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += (long) price * i;
            }
            long total = money - sum;

            return total > 0 ? 0 : Math.abs(total);
        }

        //등차수열 합 공식[r(n(n+1))/2]
        public long solution2(int price, int money, int count) {
            return Math.max(price * (count * (count + 1) / 2) - money, 0);

        }
    }
}
