package com.coding.programmers.level0;

import java.util.Stack;

public class 컨트롤제트 {
    public static void main(String[] args) {
        System.out.println(solution("10 Z 20 Z 1"));
    }

    public static int solution(String s) {
        String[] split = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : split) {
            if (str.equals("Z")) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }
        return stack.stream().mapToInt(Integer::parseInt).sum();
    }
}
