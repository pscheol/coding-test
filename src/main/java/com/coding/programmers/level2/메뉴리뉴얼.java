package com.coding.programmers.level2;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        private static Map<Integer, Map<String, Integer>> COURSE_MAP = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            for (int i : course) {
                COURSE_MAP.put(i, new HashMap<>());
            }

            for (String order : orders) {
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                combination(0, orderArr, "");
            }
            List<String> answer = new ArrayList<>();

            for (Map<String, Integer> map : COURSE_MAP.values()) {
                map.values()
                    .stream()
                    .max(Comparator.comparing(o -> o))
                    .ifPresent(count ->
                            {
                                map.entrySet()
                                        .stream()
                                        .filter(entry -> count.equals(entry.getValue()) && count > 1)
                                        .forEach(entry -> {
                                            answer.add(entry.getKey());
                                        });
                            }
                            );

            }

            Collections.sort(answer);

            return answer.toArray(new String[0]);
        }

        //조합 재귀
        public void combination(int idx, char[] order, String result) {
            //메뉴수와 일치하는 것만 저장
            if (COURSE_MAP.containsKey(result.length())) {

                Map<String, Integer> map = COURSE_MAP.get(result.length());
                //코스 수 증가
                map.put(result, map.getOrDefault(result, 0) + 1);
                COURSE_MAP.put(result.length(), map);
            }


            for (int i = idx; i < order.length; i++) {
                combination(i + 1, order, result + order[i]);
            }
        }
    }
}
