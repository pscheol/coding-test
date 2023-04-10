package com.coding.backjoon;

import java.util.Scanner;

public class DNA비밀번호_12891 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();
        int P = scan.nextInt();

        int[] checkArr = new int[4];
        int[] resArr = new int[4];
        String DNAStr = scan.next();
        char[] dna = DNAStr.toCharArray();
        int checkCnt = 0;
        int result = 0;

        for (int i = 0; i < 4; i++) {
            checkArr[i] = scan.nextInt();
            if (checkArr[i] == 0) {
                checkCnt++;
            }
        }

        for (int i = 0; i < P; i++) {
            checkCnt = add(checkArr, resArr, dna, i, checkCnt);
        }

        result += checkResult(checkCnt);

        for (int i = P; i < S; i++) {
            int pp = i - P;

            checkCnt = add(checkArr, resArr, dna, i, checkCnt);
            checkCnt = remove(checkArr, resArr, dna, pp, checkCnt);
            result += checkResult(checkCnt);

        }
        System.out.println(result);
    }

    private static int add(int[] checkArr, int[] resArr, char[] dna, int i, int checkCnt) {
        int idx = getIdx(dna, i);

        if (++resArr[idx] == checkArr[idx]) {
            checkCnt++;
        }
        return checkCnt;
    }


    private static int remove(int[] checkArr, int[] resArr, char[] dna, int i, int checkCnt) {
        int idx = getIdx(dna, i);

        if (resArr[idx]-- == checkArr[idx]) {
            checkCnt--;
        }
        return checkCnt;
    }


    private static int getIdx(char[] dna, int i) {
        int idx = 0;
        switch (dna[i]) {
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

    private static int checkResult(int checkCnt) {
        if (checkCnt == 4) {
            return 1;
        }
        return 0;
    }
}
