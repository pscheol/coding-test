package coding.programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 약수구하기 {
    public static void main(String[] args) {
        solution(24);
    }

    public static int[] solution(int n) {
        System.out.println(Arrays.toString(IntStream.range(1, n + 1).filter(i -> n % i == 0).toArray()));;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        return null;
    }
}
