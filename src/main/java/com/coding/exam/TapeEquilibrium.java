package com.coding.exam;

/**
 * 3 1 2 4 3
 * 3 4 6 10 13*
 *
 *
 * P1= | 3 - (1+2+4+3)=10 | = 7
 * P2= | 4 - (2+4+3)=9 | = 5
 * P3= | 6 - (4+3)=7 | = 1
 * P4= | 10 - (3)=3 |= 7
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] a = new int[] {3,1,2,4,3};
        System.out.println(solution(a));
    }
    public static int solution(int[] A) {
        int result = Integer.MAX_VALUE;
        int n = A.length;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += A[i];
        }

        for (int i = 0; i < n-1; i++) {
            sum += A[i];
            result = Math.min(result, Math.abs(sum - (total- sum)));
        }




        return result;
    }
}
