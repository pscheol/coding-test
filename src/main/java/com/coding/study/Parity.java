package com.coding.study;

public class Parity {
    public static void main(String[] args) {
        System.out.println(parity(8));
        System.out.println(parity1(8));

    }

    /**
     * big O(n)
     * @param x
     * @return
     */
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1); // ^ : XOR
            System.out.println("result ^= (x & 1) : " + result);
            x >>>= 1; // x / 2^1
        }
        return result;
    }

    /**
     * big O (k)
     * x & (x - 1)
     * @param x
     * @return
     */
    public static short parity1(int x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            System.out.println("result ^= 1 : " + result);
            x &= (x - 1);
            System.out.println("x &= (x - 1) : " + x);
        }
        return result;
    }
}
