package com.coding.study;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(countBits(10));
        System.out.println((16 >> 3));
        System.out.println((3 << 2));
    }

    /**
     * 1로 세팅된 비트의 개수를 찾는 프로그램
     * 최하이 비트부터 시작해서 한번에 한 비트 씩 테스트
     * shift와 mask를 사용. 단어크기에 관계 없이 비트의 개수를 방법을 알 수 있음.
     * @param x
     * @return
     */
    public static short countBits(int x) {
        short numBits = 0;
        while (x != 0) {
            System.out.println("X & 1="+ (x & 1));
            System.out.println("x >>> 1="+ (x >>> 1));
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }
}
