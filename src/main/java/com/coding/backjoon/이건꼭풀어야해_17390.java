package com.coding.backjoon;

import java.io.*;
import java.util.Arrays;

public class 이건꼭풀어야해_17390 {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = bf.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int Q = Integer.parseInt(split[1]);
            int[] S = new int[N + 1];
            String[] nums = bf.readLine().split(" ");
            int[] A = new int[N];
            for (int i = 0; i < nums.length; i++) {
                A[i] = Integer.parseInt(nums[i]);
            }
            Arrays.sort(A);

            for (int i = 1; i <= A.length; i++) {
                S[i] = S[i - 1] + A[i - 1];
            }

            for (int i = 0; i < Q; i++) {
                String[] se = bf.readLine().split(" ");
                int s = Integer.parseInt(se[0]);
                int e = Integer.parseInt(se[1]);
                bw.write(S[e] - S[s - 1] + "\n");
            }
            bw.flush();
        } catch (Exception e) {

        } finally {
            bw.close();
        }
    }
}
