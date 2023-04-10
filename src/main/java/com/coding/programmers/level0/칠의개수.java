package com.coding.programmers.level0;

import java.util.stream.Collectors;

//7의 개수
public class 칠의개수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 77, 17}));
    }
    public static int solution(int[] array) {
        StringBuilder concat = new StringBuilder();
        for (int i : array) {
            concat.append(i);
        }
        return (int) concat.toString().chars().filter(v -> v - 48 == 7)
                .mapToObj(String::valueOf)
                .count();
    }
}
