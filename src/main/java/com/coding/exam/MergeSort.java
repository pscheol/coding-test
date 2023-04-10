package com.coding.exam;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[] {27, 10, 12, 20, 25, 13, 15, 22};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] src, int left ,int right) {
        int[] tmp = new int[src.length];
        msort(src, tmp, left, right);

    }

    public static void msort(int[] src, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
    //        System.out.println("i=" + left + "mid="+mid + "right=" + right);
            msort(src, tmp, left, mid);
            msort(src, tmp,mid + 1, right);
            combine(src, tmp, left, mid, right);
        }
    }

    public static void combine(int[] src, int[]tmp, int left , int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (src[i] <= src[j]) {
                tmp[k++] = src[i++];
            } else {
                tmp[k++] = src[j++];
            }
        }

        if (i > mid) {
            for (int l = j; l <= right; l++) {
                tmp[k++] = src[l];
            }
        } else {
            for (int l = i; l <= mid; l++) {
                tmp[k++] = src[l];
            }
        }

        for (int l = left; l <= right; l++) {
            src[l] = tmp[l];
        }
    }
}
