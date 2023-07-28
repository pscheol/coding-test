package com.coding.exam;

public class Twopointer {
    public static void main(String[] args) {
      int n = 15;
      int start = 1;
      int end = 1;
      int sum = 1;
      int count = 1;

      while (end < n) {
        if (sum > n) {
            sum-=start;
            start++;
        } else if(sum < n) {
            end++;
            sum += end;
        } else {
            end++;
            sum += end;
            count++;
        }
      }
        System.out.println(count);
    }
}
