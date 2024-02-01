package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 블랙잭_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < line2.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        System.out.println(solution(nums, n, m));

        System.out.println(solution2(nums, n, m, 0, 0,0));
    }
    public static int solution(int[] nums, int n, int m) {
        int answer = -1;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n -1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum <= m) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        return answer;
    }

    public static int solution2(int[] nums, int n, int m, int sum, int idx, int cnt) {
       if (cnt == 3) {
           return sum <= m ? sum : 0;
       }
       if (idx >= n) {
           return 0;
       }
       int max = 0;
       for (int i = idx; i < n; i++) {
           max = Math.max(max, solution2(nums, n, m, sum + nums[i], i + 1, cnt +1));
       }
       return max;
    }
}
