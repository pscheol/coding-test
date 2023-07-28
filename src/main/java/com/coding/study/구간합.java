package com.coding.study;


import java.util.Arrays;

public class 구간합 {
    public static void main(String[] args) {
        sumArr();
        sumMultiAry();
    }
    /**
     * * 합배열 S를 만드는 공식 S[i] = S[i-1] + A[i];
     * * 구간 합을 구하는 공식 S[j] - S[i-1]
     */
    public static void sumArr() {
        int[] a = new int[]{5,4,3,2,1};
        int[] s = new int[a.length + 1];

        for (int i = 1; i <= a.length; i++) {
            s[i] = s[i - 1] + a[i-1];
        }
        System.out.println(Arrays.toString(s));
        //ex (1,3) S[3] - S[1-1] = 12
        System.out.println(s[3] - s[0]);

        //ex (2,4) S[4] - S[2-1] = 9
        System.out.println(s[4] - s[2-1]);
    }

    /**
     * 2차원 배열 합배열 공식 D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + a[i][j];
     * 2차원 배열 구간합 공식 sum = D[x2][y2] - D[x1-1][y2] - D[x2-1][y1-1] + D[x1-1][y1-1];
     */
    public static void sumMultiAry() {
        int[][] a = new int[][] {{1,2,3,4}, {2,3,4,5}, {3,4,5,6}, {4,5,6,7}};
        int[][] s = new int[a.length + 1][a[0].length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= a[i-1].length; j++) {
                s[i][j] = s[i][j-1] + s[i-1][j] - s[i-1][j-1] + a[i-1][j-1];
            }
        }

        for (int[] i : s) {
            System.out.println(Arrays.toString(i));
        }
        // (2,2, 3,4) 구간합
        System.out.println(s[3][4] - s[1][4] - s[3][1] + s[1][1]);
    }


}
