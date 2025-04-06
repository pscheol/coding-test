package com.coding.programmers.level1;

public class 지폐접기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result1 = sol.solution(new int[] {30 ,15}, new int[] {26,17});
        System.out.println(result1);
        int result2 = sol.solution(new int[] {50 ,50}, new int[] {100, 241});
        System.out.println(result2);
    }
    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            while (min(bill) > min(wallet) || max(bill) > max(wallet)) {
                bill[bill[0] > bill[1] ? 0 : 1] /= 2;
                answer++;
            }

            return answer;
        }
        private int min(int[] arr) {
            return Math.min(arr[0], arr[1]);
        }
        private int max(int[] arr) {
            return Math.max(arr[0], arr[1]);
        }
    }
}
