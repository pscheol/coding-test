package com.coding.backjoon;

import java.io.*;

public class 나머지합_10986 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        long[] S = new long[N + 1];
        long[] C = new long[M];
        String[] nums = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + Long.parseLong(nums[i-1]);
        }

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            int r = (int)(S[i] % M);
            if (r == 0) {
                answer++;
            }
            C[r]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
