package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 실패율 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        //[3,4,2,1,5]
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
    }
}
