package com.coding.programmers.level0;

import java.util.stream.IntStream;

public class K개의수 {
    public static void main(String[] args) {
        System.out.println(solution(10 , 50, 5));
    }
    public static int solution(int i, int j, int k) {
        return IntStream.rangeClosed(i , j).map(op -> {
            int cnt = 0;
            while (op != 0) {
                if (op % 10 == k) {
                    cnt++;
                }
                op /= 10;
            }
            return cnt;
        }).sum();
    }


}
