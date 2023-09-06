package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1,1,3,3,0,1,1})));
    }
    public static class Solution {
        public int[] solution(int [] arr) {
            Stack<Integer> answer = new Stack<>();
            answer.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (answer.peek() != arr[i]) {
                    answer.push(arr[i]);
                }
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] solution2(int [] arr) {
            List<Integer> answer = new ArrayList<>();
            answer.add(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                if (answer.get(answer.size() - 1) != arr[i])  {
                    answer.add(arr[i]);
                }
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
