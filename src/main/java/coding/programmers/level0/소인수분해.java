package coding.programmers.level0;

import java.util.HashSet;
import java.util.Set;

public class 소인수분해 {
    public static void main(String[] args) {
        int[] answer;
        int n = 420;
        int a = n;
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            while (a % i == 0) {
                a /= i;
                set.add(i);
            }
        }
        answer = set.stream().sorted().mapToInt(v -> v).toArray();
    }

}

