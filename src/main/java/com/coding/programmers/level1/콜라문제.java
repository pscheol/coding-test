package com.coding.programmers.level1;

public class 콜라문제 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2, 1, 20));
        System.out.println(sol.solution(3, 1, 20));
        System.out.println(sol.solution(5, 3, 21));

        System.out.println(sol.solution2(2, 1, 20));
        System.out.println(sol.solution2(3, 1, 20));
        System.out.println(sol.solution2(5, 3, 21));

    }
    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            int s = n;
            int d;
            do {
                d = (s / a);
                s = s - (d * a) + d * b;
                answer += d * b;
            } while (d >= 1);
            return answer;
        }

        public int solution2(int a, int b, int n) {
            return (n > b ? n - b : 0) / (a - b) * b;
        }
    }
}
