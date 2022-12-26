package coding.programmers.level0;

public class 인덱스바꾸기 {
    public static void main(String[] args) {
        System.out.println(solution("hello", 1,2));
    }
    public static String solution(String my_string, int num1, int num2) {
        char ch1 = my_string.charAt(num1);
        char ch2 = my_string.charAt(num2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (i == num1) {
                sb.append(ch2);
            } else if (i == num2) {
                sb.append(ch1);
            } else{
                sb.append(my_string.charAt(i));
            }

        }
        return sb.toString();
    }
}
