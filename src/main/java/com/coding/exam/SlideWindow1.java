package com.coding.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SlideWindow1 {

    static int[] myArr = new int[4];
    static int checkSecret = 0;
    static int[] checkArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String dnaStr = br.readLine();
        checkArr = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> {
            int r = Integer.parseInt(value);
            if (r == 0)
                checkSecret++;
                return r;
        }).toArray();

        char[] dnaArr = dnaStr.toCharArray();

        for (int i = 0; i < line1[1]; i++) {
            add(dnaArr[i]);
        }
        if (checkSecret == 4) {
            result++;
        }

        for (int i = line1[1]; i < line1[0]; i++) {
            int j = i - line1[1];
            add(dnaArr[i]);
            remove(dnaArr[j]);
            if (checkSecret == 4) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void add(char ch) {
        switch (ch) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void remove(char ch) {
        switch (ch) {
            case 'A':

                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;

                break;
            case'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
