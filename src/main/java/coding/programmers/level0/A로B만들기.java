package coding.programmers.level0;

public class A로B만들기 {
    public static void main(String[] args) {
        System.out.println(solution("ehtemwohs", "showmethe"));
    }

    public static int solution(String before, String after) {
        return (before.chars().sum() == after.chars().sum()) ? 1 : 0;
    }
}
