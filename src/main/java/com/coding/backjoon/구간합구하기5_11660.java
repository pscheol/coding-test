package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 구간합구하기5_11660 {
    public static void main(String[] args) {

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String[] MN = bf.readLine().split(" ");
            int N = Integer.parseInt(MN[0]);
            int M = Integer.parseInt(MN[1]);
            int[][] S = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
               String[] nums = bf.readLine().split(" ");
               for (int j = 1; j <= nums.length; j++) {
                   S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + Integer.parseInt(nums[j-1]);
               }
            }
            for (int i = 0; i < M; i++) {
                String[] xy = bf.readLine().split(" ");
                int x1 = Integer.parseInt(xy[0]);
                int y1 = Integer.parseInt(xy[1]);
                int x2 = Integer.parseInt(xy[2]);
                int y2 = Integer.parseInt(xy[3]);
                int answer = S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1];
                System.out.println(answer);
            }


        } catch (Exception e) {

        }
    }
}

