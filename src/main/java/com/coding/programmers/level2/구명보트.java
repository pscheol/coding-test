package com.coding.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 구명보트 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{70,50,80,50}, 100));
    }
    private static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int front = 0;
            int rear = people.length - 1;

            while (front <= rear) {
                if ((people[front] + people[rear]) <= limit) {
                    front++;
                    rear--;
                } else {
                    rear--;
                }
                answer++;
            }

            return answer;
        }
    }
}
