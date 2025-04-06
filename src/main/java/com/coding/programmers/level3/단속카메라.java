package com.coding.programmers.level3;

import java.util.*;

/**
 * 	1.	정렬 후: {{-20,-15}, {-18,-13}, {-14,-5}, {-5,-3}}
 * 	2.	첫 번째 차량 → -15에 카메라 설치
 * 	•	이 카메라로 -20 ~ -15, -18 ~ -13 차량 커버됨
 * 	3.	다음 차량 [-14,-5] → 진입점 -14는 -15보다 크지 않음 → 커버됨
 * 	4.	차량 [-5,-3] → 진입점 -5는 -15보다 큼 → 커버 안됨 → 새 카메라 -3에 설치
 *
 * 최종 카메라 개수: 2
 */
public class 단속카메라 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(
                new int[][] {
                        {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}
                }
        );
        System.out.println(result);
    }
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
            int comparePosition = Integer.MIN_VALUE;
            for (int[] route : routes) {
                if (route[0] > comparePosition) {
                    comparePosition = route[1];
                    answer++;
                }
            }

            return answer;
        }

    }
}
