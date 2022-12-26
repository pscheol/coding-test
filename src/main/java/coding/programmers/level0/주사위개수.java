package coding.programmers.level0;

import java.util.Arrays;

public class 주사위개수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10,8,6}, 3));
    }

    public static int solution(int[] box, int n) {
        return Arrays.stream(box).map(b -> b / n).reduce((l,r) -> l*r).orElse(0);
    }
}
