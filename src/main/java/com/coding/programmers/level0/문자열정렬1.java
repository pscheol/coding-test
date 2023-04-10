package com.coding.programmers.level0;

import java.util.Arrays;

public class 문자열정렬1 {
    public static void main(String[] args) {
        String my_string = "hi12392".replaceAll("[a-zA-z]", "");
        int[] answer = my_string.chars().mapToObj(c -> c - 48).sorted().mapToInt(v -> v).toArray();
        System.out.println(Arrays.toString(answer));
    }
}
