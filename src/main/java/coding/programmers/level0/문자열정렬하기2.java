package coding.programmers.level0;

import java.util.stream.Collectors;

public class 문자열정렬하기2 {
    public static void main(String[] args) {
        System.out.println(solution("abcdE"));
    }
    public static String solution(String my_string) {
        return my_string.chars().mapToObj(ch -> {
            int result = ch;
            if (!(ch >= 'a' && ch <= 'z')) {
                result = ch + 32;
            }
            return String.valueOf((char)result);

        }).sorted().collect(Collectors.joining());

    }
}
