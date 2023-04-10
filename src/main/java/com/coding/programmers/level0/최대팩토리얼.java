package com.coding.programmers.level0;

public class 최대팩토리얼 {
    public static void main(String[] args) {
        System.out.println(solution(3628800));
    }
    public static int solution(int n) {
        int answer = factorial(1);
        for (int i = 2; i <= 10; i++) {
            int tmp = factorial(i);
            if (answer < tmp && factorial(i)  <= n) {
                answer = i;
            }
        }
        return answer;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
