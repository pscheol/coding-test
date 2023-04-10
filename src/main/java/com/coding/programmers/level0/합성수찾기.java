package com.coding.programmers.level0;

import java.util.HashSet;
import java.util.Set;

public class 합성수찾기 {
    public static void main(String[] args) {
        int n = 10;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 2; j < i; j++) {
                if(i % j == 0)
                    set.add(i);
            }
        }
        System.out.println(set.size());
    }
}

/**
 * 4,6 8,9,10
 *
 * * * *
 */