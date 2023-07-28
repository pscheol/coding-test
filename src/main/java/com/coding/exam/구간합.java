package com.coding.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(sum));

        int n = Integer.parseInt(line1[1]);
        for (int i = 0; i < n; i++) {
            int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(range[0], range[1], sum));
        }
    }
    public static int solution(int start, int end, int[] sum) {
        return sum[end] - sum[start - 1];
    }
}
