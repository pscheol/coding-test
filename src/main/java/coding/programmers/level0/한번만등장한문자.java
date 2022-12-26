package coding.programmers.level0;

import java.util.Arrays;

public class 한번만등장한문자 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcadc"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    count++;
                }
            }
            if (count <= 1) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
