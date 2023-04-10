package com.coding.programmers.level0;

public class 최댓값만들기2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,-3,4,-5}));
    }
    public static int solution(int[] numbers) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i< numbers.length; i++) {
            int n1 = numbers[i];
            for (int j = i; j < numbers.length; j++) {

                answer = Math.max(answer, n1 * numbers[j]);
            }
        }
        return answer;
    }
}
