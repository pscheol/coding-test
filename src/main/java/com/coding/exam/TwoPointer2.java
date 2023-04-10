package com.coding.exam;

import java.util.Arrays;

public class TwoPointer2 {
    public static void main(String[] args) {
        int n = 6;
        int m = 9;
        int[] a = new int []{2,7,4,1,5,3};
        int count = 0;
        Arrays.sort(a);
        int i = 0;
        int j = n - 1;
        while(i < j) {
            if (a[i] + a[j] < m) {
                i++;
            } else if (a[i] + a[j] > m) {
                j--;
            } else { //equals
                i++; j--;
                count++;
            }
        }
        System.out.println(count);
    }
}
