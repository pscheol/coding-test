package com.coding.programmers.level1;

public class 신규아이디추천 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijkl m"));
        System.out.println(sol.solution("z-+.^."));

        System.out.println(sol.solution("=.="));

        System.out.println(sol.solution("123_.def"));
        System.out.println(sol.solution("abcdefghijklmn.p"));
    }

    /**
     * * 규칙이 맞지 않는 아이디를 입력 했을 때.
     * 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발.*
     * 아이디 길이 3 to 15
     * 알파벳 소문자, 숫자 , (-), (_), (.) 만 가능.
     * 마침표는 처음과 끝에 사용 불가능. 연속 사용 불가능.*
     * *
     */
    private static class Solution {
        public String solution(String new_id) {
            String answer = new_id.toLowerCase(); //소문자로
            answer = answer.replaceAll("[^-_.a-z0-9]", ""); //특수문자 제거
            answer = answer.replaceAll("\\.{2,}", "."); //. 마침표 하나로 변환

            answer = answer.replaceAll("^\\.|\\.$", ""); //. 제거

            if (answer.length() == 0) {
                for (int i = 0 ; i < 3; i ++) {
                    answer += "a";
                }
            } else {
                answer = answer.replaceAll(" ", "a"); //. 빈문자열 s로 변환

                if (answer.length() >= 16) {
                    answer = answer.substring(0, 15);
                    answer = answer.replaceAll("^\\.|\\.$", ""); //. 제거
                }

                if (answer.length() <= 2) {
                    while(answer.length() < 3) {
                        answer += answer.charAt(answer.length() - 1);
                    }
                }
            }

            return answer;
        }
    }
}
