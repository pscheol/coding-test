package com.coding.programmers.level1;

public class 음양더하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
    }
    static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for (int i = 0; i < absolutes.length; i++) {
                answer += signs[i] ?  absolutes[i] : -absolutes[i];
            }
            return answer;
        }
    }
}
