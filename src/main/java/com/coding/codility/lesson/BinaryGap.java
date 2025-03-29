package com.coding.codility.lesson;

public class BinaryGap {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = sol.solution(32);
        System.out.println(a);

    }
    static class Solution {
        public int solution(int N) {
            int n = N;
            int answer = 0;
            int count = 0;
            boolean open = false;
            while (n >  0) {
                int bit = n % 2;
                if (open && bit == 0) {
                    System.out.println("skemfdjdha");
                    count++;
                } else if (bit == 1) {
                    open = true;
                    System.out.println("ans = " + answer);
                    System.out.println("count = " + count);
                    answer = Math.max(answer, count);
                    count = 0;
                }
                System.out.println(bit);
                n = n / 2;
            }
            return answer;
        }
    }
}
