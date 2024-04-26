package com.coding.programmers.level1;

import java.util.*;

/**
 게시판 불량이용자신고 처리 메일 발송 시스템
 - 유저는 한번에 한 명의 유저를 신고
     - 신고횟수 제한 x
     - 서로다른 유저를 계속 신고
     - 한 유저를 여러번 신고 but, 동일 유저에 대한 신고는 1회 처리
 - k번 이상 신고된 유저 게시판 이용정지하고 신고한 유저에게 메일 발송
    - 신고 내용을 취합 후 마지막에 한번에 게시판 이용정지를 시키고, 정지메일 발송

 이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report
 , 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때
 , 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 ---
 id_list	report	k	result
 ["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
 ["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]

 muzi   : frodo  = muzi [frodo, neo] = 2
 apeach : frodo  = apeach [frodo] = 1
 frodo  : neo    = frodo [neo] = 1
 muzi   : neo    = neo [] = 0
 apeach : muzi   = apeach [muzi] = 1
 */
public class 신고결과받기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{
                 "muzi frodo"
                ,"apeach frodo"
                ,"frodo neo"
                ,"muzi neo"
                ,"apeach muzi"}, 2);

        int[] result2 = sol.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }
    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Set<String>> reportMap = new LinkedHashMap<>();
            Map<String, Integer> reportCount = new LinkedHashMap<>();

            for (String list : report) {
                String[] split = list.split(" ");
                String u = split[0];
                String r = split[1];
                Set<String> reportSet = reportMap.getOrDefault(r, new HashSet<>());
                reportSet.add(u);
                reportMap.put(r, reportSet);
            }

            reportMap.forEach((r, set) -> {
                if (set.size() >= k) {
                    for (String u : set) {
                        reportCount.put(u, reportCount.getOrDefault(u, 0) + 1);
                    }
                }
            });

            int[] answer = new int[id_list.length];

            for (int i = 0; i < id_list.length; i++) {
                answer[i] = reportCount.getOrDefault(id_list[i], 0);
            }
            return answer;
        }
    }
}
