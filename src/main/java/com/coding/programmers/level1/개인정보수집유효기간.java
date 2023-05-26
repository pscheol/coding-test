package com.coding.programmers.level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 개인정보 n개 유효기간 지나면 파기
 * todaay : 오늘날짜
 * terms : 약관종류 유효기간
 * privacies : 개인정보수집일자  약관종류
 */
public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}
                , new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }

    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();
            LocalDate toDayDate = parseLocalDate(today);
            Map<String, Integer> termMap = new LinkedHashMap<>();
            for (String term : terms) {
                String[] split = term.split(" ");
                termMap.put(split[0], Integer.parseInt(split[1]));
            }

            for (int i = 0; i < privacies.length; i++) {
                String[] split = privacies[i].split(" ");
                LocalDate checkDate = parseLocalDate(split[0]).plusMonths(termMap.get(split[1])).minusDays(1);
                if (toDayDate.isAfter(checkDate)) {
                    answer.add(i + 1);
                }
            }


            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
        private LocalDate parseLocalDate(String src) {
            return LocalDate.parse(src, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        }
    }
}
