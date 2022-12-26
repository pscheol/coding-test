package coding.programmers.level0;

public class 모음제거 {
    public static void main(String[] args) {
        String my_string = "bus".replaceAll("[aeiou]", "");
        System.out.println(my_string);
    }
}
