package com.coding.exam;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {2,4,7,9,1,3,6,8,5};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] src, int left ,int right) {
        System.out.println("quicksort left=" + left + ", right=" + right);
        if (left >= right) {
            return;
        }
        int p = position(src, left, right);
        System.out.println("position =" + p);
        quicksort(src, left, p - 1);
        quicksort(src, p + 1, right);
    }

    public static int position(int[] src, int left, int right) {
        int pivot = src[left];
        int low = left;
        int high = right + 1;

        do {
            do {
                low++;
            } while (low <= right && src[low] < pivot);

            do {
                high--;
            } while (high >= left && src[high] > pivot);

            if (low < high) {
                swap(src, low, high);
            }
        } while(low < high);

        swap(src, left, high);
        return high;

    }

    private static void swap(int[] src, int low, int high) {
        int tmp = src[low];
        src[low] = src[high];
        src[high] = tmp;
    }
}
