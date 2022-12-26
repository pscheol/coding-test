package coding.programmers.level0;

import java.util.Arrays;

public class 가까운수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 10, 28}, 20));
    }
    public static int solution(int[] array, int n) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(array);
        for (int i : array) {
            int m = Math.abs(n - i);
            if (m < min) {
                min = m;
                answer = i;
            }
        }
        return answer;
    }
}
