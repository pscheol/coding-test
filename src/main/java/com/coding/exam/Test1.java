package com.coding.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        int[] sum = new int[n+1];
        String[] nn = br.readLine().split(" ");
        int cnt = 1;
        for (String s : nn) {
            sum[cnt] = sum[cnt-1] + Integer.parseInt(s);
            cnt++;
        }

        for (int i = 0; i < q; i++) {
            String[] qq = br.readLine().split(" ");
            int q1 = Integer.parseInt(qq[0]);
            int q2 = Integer.parseInt(qq[1]);

            System.out.println(sum[q2] - sum[q1-1]);

        }

    }
}

