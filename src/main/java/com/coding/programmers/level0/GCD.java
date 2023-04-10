package com.coding.programmers.level0;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(24, 16));
        System.out.println(gcd2(24, 16));
        System.out.println(lcm(72, 30));
    }

    public static int gcd(int a, int b) {
        if (b <= 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int gcd2(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);

    }
}

/**
 * p = 6*
 *  6 = 1;
 *  4 = 2;
 *  10 *
 */