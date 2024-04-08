package com.coding.programmers.level1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(sol.solution2(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            List<Double[]> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                int stg = 0;
                int fl = 0;
                for (int j = 0; j < stages.length; j++) {
                    if (stages[j] >= i) {
                        stg++;
                        if (stages[j] <= i) {
                            fl++;
                        }
                    }
                }
                Double[] failed = stg == 0 ? new Double[]{(double)i, 0d} : new Double[]{(double)i, (double)fl / stg};
                list.add(failed);
            }

            list.sort((a, b) -> Double.compare(b[1], a[1]));

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i)[0].intValue();
            }
            return answer;
        }


        public int[] solution2(int N, int[] stages) {
            double[] challenger = new double[N + 2]; // 1 to N;
            //도전자 수
            for (int stage : stages) {
                challenger[stage]++;
            }

            //실패한 사용자 수 계산
            Map<Integer, Double> fails = new HashMap<>();
            double total = stages.length;
            //실패율 계산
            for (int i = 1; i <= N; i++) {
                //도전한 사람이 없는 경우
                if (challenger[i] == 0) {
                    fails.put(i, 0.);
                    continue;
                }
                //실패율 계산
                fails.put(i, (challenger[i] / total));
                total -= challenger[i];
            }

            return fails.entrySet().stream()
                    .sorted((o1 ,o2) -> Double.compare(o2.getValue(), o1.getValue()))
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}
