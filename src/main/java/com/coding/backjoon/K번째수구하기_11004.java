package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수구하기_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        String[] an = br.readLine().split(" ");
        int[] arr = new int[Integer.parseInt(nk[0])];
        for (int i = 0; i < an.length; i++) {
            arr[i] = Integer.parseInt(an[i]);
        }
        int k = Integer.parseInt(nk[1]);
        int n = Integer.parseInt(nk[0]);
        qsort(arr, 0, n - 1, k - 1);

        System.out.println(arr[k - 1]);

    }
    public static void qsort(int[] src, int left ,int right, int k) {
        if (left < right) {
            int p = position(src, left, right);

            if (p == k) {
                return;
            } else if (p > k) {
                qsort(src, left, p - 1, k);
            } else {
                qsort(src, p + 1, right, k);
            }
        }
    }

    public static int position(int[] src, int left, int right) {
        if (left + 1 == right) {
            if (src[left] > src[right]) {
                swap(src, left, right);
                return right;
            }
        }

        int mid = (left + right) / 2;
        swap(src, left, mid);

        int pivot = src[left];
        int low = left + 1;
        int high = right;

        while (low <= high) {
            while(high > 0 && src[high] > pivot) {
                high--;
            }
            while(low < src.length - 1 && src[low] < pivot) {
                low++;
            }
            if (low <= high) {
                swap(src, low++, high--);
            }
        }

        swap(src, left, high);
        return high;
    }
    private static void swap(int[] src, int low, int high) {
        int tmp = src[low];
        src[low] = src[high];
        src[high] = tmp;
    }
}
