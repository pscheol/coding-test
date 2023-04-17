package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();
        while (n != 0) {
            answer.add((int)n % 10);
            n = n / 10;
        }
        return answer.stream().mapToInt(m -> m).toArray();
    }
}
