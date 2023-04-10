package com.coding.exam;

public class PrefixSum {
    public static void main(String[] args) {
        int[][] a = new int[][] {{0,1,2,3,4}, {0,2,3,4,5}, {0,3,4,5,6}, {0,4,5,6,7}};
        int[][] sum = new int[a.length+1][a.length+1];


        for (int i = 0 ; i < a.length; i++) {

            for (int j = 1; j < a[i].length; j++) {
                sum[i+1][j] = sum[i+1][j-1] + sum[(i+1)-1][j] - sum[(i+1)-1][j-1] + a[i][j];
            }
        }


        int x1 = 2;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;

        int result = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
        System.out.println(result);
    }
}
// 1 3 6 7 9
// 1 0 0 1 0
