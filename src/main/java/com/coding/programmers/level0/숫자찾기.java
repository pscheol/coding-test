package com.coding.programmers.level0;

public class 숫자찾기 {
    public static void main(String[] args) {
        System.out.println(solution(12305,0));
    }
    public static int solution(int num, int k) {
        int answer = -1;
        String n = String.valueOf(num);
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) - '0' == k) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}
