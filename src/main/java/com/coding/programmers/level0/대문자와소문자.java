package com.coding.programmers.level0;

import java.util.stream.Collectors;

public class 대문자와소문자 {
    public static void main(String[] args) {
        String my_string = "cccCCC";
        System.out.println((char)('c' - 32));
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            sb.append(c >= 97 ? (char)(c - 32) : (char)(c + 32));
        }
        System.out.println(sb.toString());

        String answer = my_string.chars().mapToObj(op -> op >= 97 ? String.valueOf((char)(op - 32)) : String.valueOf((char)(op + 32)))
                        .collect(Collectors.joining());
        System.out.println(answer);
    }
}
