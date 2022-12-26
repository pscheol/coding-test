package coding.programmers.level0;

public class 삼육구게임 {
    public static void main(String[] args) {

    }
    public int solution(int order) {
        int answer = 0;
        while (order != 0) {
            int o = order % 10;
            if (o == 3 || o == 6 || o == 9) {
                answer++;
            }
            order /= 10;
        }
        return answer;
    }
}
