package com.coding.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int[][] arrNum = new int[n][n];
        int[][] arrSum = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < nums.length; j++) {
                arrNum[i][j] = nums[j];
            }
        }


        for (int i = 1; i < arrSum.length; i++) {
            for (int j = 1; j < arrSum[i].length; j++) {
                arrSum[i][j] = arrSum[i][j-1] + arrSum[i-1][j] - arrSum[i-1][j-1] + arrNum[i-1][j-1];
            }
        }

        int s = Integer.parseInt(line1[1]);
        for (int i = 0; i < s; i++) {
            int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = range[0];
            int y1 = range[1];
            int x2 = range[2];
            int y2 = range[3];
            System.out.println(arrSum[x2][y2] - arrSum[x1-1][y2] - arrSum[x2][y1-1] + arrSum[x1-1][y1-1]);


        }
    }

}
