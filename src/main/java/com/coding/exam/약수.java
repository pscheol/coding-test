package com.coding.exam;

import java.util.HashSet;
import java.util.Set;

public class 약수 {
    public static void main(String[] args) {
        int n = 100;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (100 % i == 0) {
                set.add(i);
                if (n / i != i) {
                    set.add(n/i);
                }
            }
        }
        System.out.println(set);
    }
}
