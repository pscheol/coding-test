package coding.programmers.level0;

public class 문자열계산하기 {
    public static void main(String[] args) {
        System.out.println(solution("3 + 4"));
    }

    public static int solution(String my_string) {
        String[] split = my_string.split(" ");
        int answer = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i+=2) {
            answer = split[i].equals("+") ? answer + Integer.parseInt(split[i+1]) : answer - Integer.parseInt(split[i+1]);
        }
        return answer;
    }
}
