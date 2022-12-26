package coding.programmers.level0;

import java.util.stream.Collectors;

public class 중복된문자제거 {
    public static void main(String[] args) {
        System.out.println(solution("people"));
    }
    public static String solution(String my_string) {
        return my_string.chars().distinct().mapToObj(v -> String.valueOf((char)v)).collect(Collectors.joining());

    }
}
