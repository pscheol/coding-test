package com.coding.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[n + 1];
        int[] c = new int[m];
        for (int i = 1; i <= arr.length; i++) {
            sum[i] = sum[i-1] + arr[i-1];
            int mod = sum[i] % m;
            if (mod == 0)
                answer++;
            c[mod]++;
        }

        for (int i = 0; i < m; i++) {
            answer += (c[i] * (c[i] - 1) / 2);
        }
        System.out.println(answer);
    }
}
