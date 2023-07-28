package com.coding.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 4개 지표로 성격유형으로 구분되며 둘 중 하나로 결정
 지표 번호	성격 유형
 1번 지표	라이언형(R), 튜브형(T)
 2번 지표	콘형(C), 프로도형(F)
 3번 지표	제이지형(J), 무지형(M)
 4번 지표	어피치형(A), 네오형(N)

 4개의 지표 성격유형 16(2x2x2x2)가지

 매우 동의, 매우 비동의 : 3점
 동의, 비동의 : 2점
 약간 동의, 약간 비동의 : 1 점
 모르겠음 : 0 점

 질문 성격 유형 점수 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격유형
 하나의 지표에서 각 성격 유형 점수가 같은면 사전순으로 빠른 성격유형 검사자의 유형
 choices	뜻
 1	매우 비동의
 2	비동의
 3	약간 비동의
 4	모르겠음
 5	약간 동의
 6	동의
 7	매우 동의

 입출력 예
 survey	choices	result
 ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
 ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"

 지표 번호	성격 유형	점수	성격 유형	점수
 1번 지표	라이언형(R)	0	튜브형(T)	3
 2번 지표	콘형(C)	1	프로도형(F)	0
 3번 지표	제이지형(J)	0	무지형(M)	2
 4번 지표	어피치형(A)	1	네오형(N)	1
 각 지표에서 더 점수가 높은 T,C,M이 성격 유형입니다.
 하지만, 4번 지표는 1점으로 동일한 점수입니다. 따라서, 4번 지표의 성격 유형은 사전순으로 빠른 A입니다.

 따라서 "TCMA"를 return 해야 합니다.
 */
public class 성격유형검사하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(sol.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    static class Solution {
        private static final Map<Integer, Integer> POINT = new HashMap<>();
        private static final String[][] EX_MAP = {{"R", "T"},{"C", "F"},{"J", "M"},{"A", "N"}};
        static {
            POINT.put(1, 3); POINT.put(2, 2); POINT.put(3, 1); POINT.put(4, 0);
            POINT.put(5, 1); POINT.put(6, 2); POINT.put(7, 3);
        }

        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();
            int[][] arrMap = new int[4][2];

            for (int i = 0; i < survey.length; i++) {
                String[] split = survey[i].split("");
                String x1 = split[0];
                String x2 = split[1];
                int choice = choices[i];
                int k1 = 0;
                int k2 = 0;
                if (choice > 4) {
                    k1 = findKey(x2);
                    k2 = findSubKey(x2);
                } else {
                    k1 = findKey(x1);
                    k2 = findSubKey(x1);
                }
                arrMap[k1][k2] = arrMap[k1][k2] + POINT.get(choice);
            }

            for (int i = 0; i < arrMap.length; i++) {
                if (arrMap[i][0] == arrMap[i][1]) {
                    answer.append(compare(EX_MAP[i][0], EX_MAP[i][1]));
                } else if (arrMap[i][0] < arrMap[i][1]) {
                    answer.append(EX_MAP[i][1]);
                } else {
                    answer.append(EX_MAP[i][0]);
                }
            }
            return answer.toString();
        }

        private String compare(String x1, String x2) {
            if (x1.charAt(0) - 'A' < x2.charAt(0) - 'A') {
                return x1;
            } else {
                return x2;
            }
        }

        private int findSubKey(String src) {
            if ("R".equals(src) || "C".equals(src) || "J".equals(src) || "A".equals(src)) {
                return 0;
            } else {
                return 1;
            }
        }

        private int findKey(String src) {
            if ("RT".contains(src)) {
                return 0;
            } else if ("CF".contains(src)) {
                return 1;
            } else if ("JM".contains(src)) {
                return 2;
            } else {
                return 3;
            }
        }
    }
}
