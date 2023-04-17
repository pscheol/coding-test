package com.coding.programmers.level1;

public class 휴대폰번호가리기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("01012341234"));
    }

    private static class Solution {
        public String solution(String phone_number) {
            return phone_number.replaceAll("\\d(?=\\d{4})", "*");
        }
    }
}

