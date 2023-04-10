package com.coding.programmers.level0;

import java.util.Map;

public class 영어가싫어요 {

    public static void main(String[] args) {
        System.out.println(solution("onefourzerosixseven"));
    }

    private static final Map<String, Integer> NUMBERS = Map.of("one", 1,"two", 2,"three", 3
            ,"four", 4,"five", 5,"six", 6,"seven", 7
            ,"eight", 8,"nine", 9,"zero", 0);

    public static long solution(String numbers) {
        String tmp = numbers;
        while (tmp.matches("^[a-z]*$")) {
            for (Map.Entry<String, Integer> entry : NUMBERS.entrySet()) {
                String k = entry.getKey();
                if (tmp.contains(k)) {
                    tmp = tmp.replaceAll(k, String.valueOf(entry.getValue()));
                }
            }
        }
        return Long.parseLong(tmp);
    }
}
