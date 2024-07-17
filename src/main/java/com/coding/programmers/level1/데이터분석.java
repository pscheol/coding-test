package com.coding.programmers.level1;

import java.util.*;
public class 데이터분석 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] result = sol.solution(new int[][]{
                    {1, 20300104, 100, 80},
                    {2, 20300804, 847, 37},
                    {3, 20300401, 10, 8}
                },
                "date", 20300501, "remain");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private static class Solution {
        private static final List<String> TARGET = List.of("code", "date", "maximum", "remain");
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            List<int[]> answer = new ArrayList<>();
            int extIdx = TARGET.indexOf(ext);
            int sortByIdx = TARGET.indexOf(sort_by);

            //ext에 따른 val_ext를 val_ext 보다 작은 데이터만 추출
            for (int i = 0; i < data.length; i++) {
                int[] row = data[i];
                if (row[extIdx] > val_ext) {
                    continue;
                }
                answer.add(row);
            }
            //sort_by 따른 정렬값, 린턴
            return answer.stream()
                    .sorted(Comparator.comparingInt(o -> o[sortByIdx]))
                    .toArray(int[][]::new);
        }
    }
}
