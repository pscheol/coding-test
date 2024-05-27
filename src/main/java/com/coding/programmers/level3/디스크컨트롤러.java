package com.coding.programmers.level3;

import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(result);
    }

    /**
     * 작업요청시간을 정렬 후
     * 우선순위큐를 이용하여 작업시간을 넣고 처리
     */
    private static class Solution {
        public int solution(int[][] jobs) {
            Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

            int answer = 0;
            int start = 0;
            int end = 0;
            int idx = 0;


            while (start < jobs.length) {
                // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
                while (idx < jobs.length && jobs[idx][0] <= end) {
                    pq.add(jobs[idx++]);
                }

                // 큐가 비어있다면 현재 idx 작업의 시간을 end로 재설정
                if (pq.isEmpty()) {
                    end = jobs[idx][0];
                } else {
                    int[] job = pq.poll();
                    answer += job[1] + end - job[0]; //작업소요시간 + 마지막 작업 소요시간 - 시작 대기시간
                    end += job[1];
                    start++;
                }
            }

            return answer / jobs.length;
        }
    }
}
