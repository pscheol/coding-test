package com.coding.programmers.level0;

public class PrimeNum {

    public static void main(String[] args) {
        prime(100);
        prime2(100);
    }

    public static void prime(int n) {

        int[] prime = new int[n];
        int pn = 0; //소수 개수
        boolean[] check = new boolean[n + 1]; //지워졋으면 true

        for (int i = 2; i < n; i++) {
            if (!check[i]) {
                prime[pn++] = i;
                for (int j = i + i; j<=n; j+=i) {
                    check[j] = true;
                }
            }
        }

        System.out.println(pn);
        for (int i : prime) {
            System.out.print(i + ", ");
        }
    }


    public static final void prime2(int n ) {
        int prime[] = new int[n];
        boolean[] check = new boolean[n+1];
        int pn = 0;

        for (int i = 2; i < n; i++) {
            if (check[i] == false) {
                prime[pn++] = i;
                for (int j = i + i; j < n; j+=i) {
                    check[j] = true;
                }
            }
        }
        System.out.println();
        System.out.println(pn);
        for (int i : prime) {
            System.out.print(i + " ");
        }
    }
}
