package com.coding.programmers.level2;

import java.util.Arrays;
import java.util.stream.LongStream;

//(1,1)(1,2)(1,3)
//(2,1)(2,2)(2,3)
//(3,1)(3,2)(3,3)
// ==
//max(1,1)max(1,2)max(1,3) = 1 2 3
//max(2,1)max(2,2)max(2,3) = 2 2 3
//max(3,1)max(3,2)max(3,3) = 3 3 3
// ==
//1차원 배열로 변환
//idx    = 0 1 2 3 4 5 6 7 8
//value  = 1 2 3 2 2 3 3 3 3

// idx / n = 2/3 = 0 + 1 = 1
// idx % n = 2%3 = 1 + 1 = 2

//1차원 배열 2번 idx 는 2차원 배열 (1,2)와 같다.
//(1,2)중 큰 값이 2차원 배열 value 이므로, 1차원 배열의 2번 idx 는 2

//-> 이런식으로 left...(right-left) 까지 구함
//(int) 형변환이 가능한 이유는 value 값은 무조건 n 이하이고, n <= 10,000,000 이다.
public class N2배열자르기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, 2, 5)));
        System.out.println(Arrays.toString(sol.solution(4, 7, 14)));
//        System.out.println(Arrays.toString(sol.solution(1, 0, 0)));
    }
    private static class Solution {
        public int[] solution(int n, long left, long right) {
            return LongStream.range(left, right + 1)
                    .mapToInt(i -> (int) Math.max((i / n + 1), (i % n + 1)))
                    .toArray();
        }
    }
}
