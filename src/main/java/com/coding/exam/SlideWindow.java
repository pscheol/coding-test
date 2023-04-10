package com.coding.exam;

public class SlideWindow {
    static int[] myArr = new int[4];
    static char[] pwd = new char[]{'A','C','G','T'};
    static int checkSecret = 0;
    static int[] checkArr = {1,0,0,1};
    public static void main(String[] args) {

        int n = 4;
        int window = 2;
        String dna = "GATA";
        char[] dnas = dna.toCharArray();

        int result = 0;
        for (int i = 0 ; i <window; i++) {
            add(dnas[i]);
        }

        if (checkSecret == 4) {
            result++;
        }

        for (int i = window; i < n; i++) {
            int j = i - window;
            add(dnas[i]);
            remove(dnas[j]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println("checkSecret=" + checkSecret);
        System.out.println(result);
    }

    public static void add(char c) {
        int idx = findIdx(c);
        myArr[idx]++;
        if (myArr[idx] == checkArr[idx]) {
            checkSecret++;
        }
    }
    public static void remove(char c) {
        int idx = findIdx(c);
        myArr[idx]--;
        if (myArr[idx] == pwd[idx]) {
            checkSecret--;
        }

    }

    private static int findIdx(char c) {
        int idx = 0;
        switch (c) {
            case 'A':
                idx = 0;
                break;
            case 'C':
                idx = 1;
                break;
            case 'G':
                idx = 2;
                break;
            case 'T':
                idx = 3;
                break;
        }
        return idx;
    }
}
