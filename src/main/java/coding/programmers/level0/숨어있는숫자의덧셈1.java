package coding.programmers.level0;

public class 숨어있는숫자의덧셈1 {
    public static void main(String[] args) {
        String my_string = "1a2b3c4d123".replaceAll("[a-zA-Z]", "");
        int answer = 0;
        for (char c : my_string.toCharArray()) {
            answer += ((int)c - 48);
        }
        System.out.println(answer);
    }
}
