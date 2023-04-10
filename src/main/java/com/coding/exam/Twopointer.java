package com.coding.exam;

public class Twopointer {
    public static void main(String[] args) {
        int n = 15;
        int s = 1;
        int e = 1;
        int sum = 1;
        int count = 1;
        while (e < n) {
            if (sum > n) {
                sum -= s;
                s++;
            } else if (sum < n) {
                sum += e;
                e++;
            } else { //equals
                e++;
                count++;
                sum += e;
            }
        }
        System.out.println(count);
    }
}
