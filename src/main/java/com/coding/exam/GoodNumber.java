package com.coding.exam;

public class GoodNumber {
    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[]{1,2,3,4,5,5,6,7,8,9,10};
        int count = 0;
        for (int i = 0 ; i < n; i++) {
            int k = a[i];
            int start = 0;
            int end = n - 1;
            while (start < end) {
                if (a[start] + a[end] > k) {
                    end--;
                } else if (a[start] + a[end] < k) {
                    start++;
                } else {
                    if (start != k && end != k) {
                        count++;
                        break;
                    } else if (start == k) {
                        start++;
                    } else {
                        end--;
                    }

                }
            }
        }

        System.out.println(count);
    }


}
