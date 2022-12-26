package coding.programmers.level0;

public class 이차원배열만들기 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[][] result = solution1(arr, 2);

        for (int i = 0; i <result.length; i++) {
            for (int j = 0 ; j < result[i].length; j++) {
                System.out.print(result[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[] num_list, int n) {
        int length = num_list.length / n;
        int cnt = 0;
        int[][] answer = new int[length][n];

        for (int i = 0; i < length; i++) {
            for (int j = 0 ; j < n; j++) {
                answer[i][j] = num_list[cnt++];
            }
        }
        return answer;
    }

    public static int[][] solution1(int[] num_list, int n) {
        int length = num_list.length;
        int[][] answer = new int[length/n][n];

        for (int i = 0; i < length; i++) {
            answer[i/n][i%n] = num_list[i];
        }
        return answer;
    }
}
