package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 버블소트프로그램2_1517 {
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        mSort(0, n - 1, arr, sorted);
        System.out.println(result);
    }

    public static void mSort(int left, int right, int[] src, int[] sorted) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mSort(left, mid, src, sorted);
        mSort(mid + 1, right, src, sorted);
        merge(left, mid, right, src, sorted);
    }
    public static void merge(int left, int mid, int right, int[] src, int[] sorted) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (src[i] > src[j]) {
                result = result + j - k;
                sorted[k++] = src[j++];
            } else {
                sorted[k++] = src[i++];
            }
        }

        if (i <= mid) {
            for (int l = i; l <= mid; l++) {
                sorted[k++] = src[l];
            }
        } else {
            for (int l = j; l <= right; l++) {
                sorted[k++] = src[l];
            }
        }

        for (int l = left; l <= right; l++) {
            src[l] = sorted[l];
        }
    }
}
