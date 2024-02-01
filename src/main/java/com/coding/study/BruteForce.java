package com.coding.study;


import java.util.List;
import java.util.Stack;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(recursiveSum(5));
        System.out.println(sum4(7));
        pick(7, new Stack<>(),5);

        Boggle boggle = new Boggle();
        String[][] board = new String[][]{
                {"U", "R" ,"L", "P", "M"},
                {"X", "P", "R", "E", "T"},
                {"G", "I", "A", "E", "T"},
                {"X", "T", "N", "Z" ,"Y"},
                {"X", "O", "Q", "R", "S"}

        };

        boolean checked = false;
        for (int i = 0 ; i <= 4; i ++) {
            for (int j = 0; j <= 4; j ++) {
                if (boggle.hasWord(i, j, "PRETTY", board)) {
                    checked = true;
                }
                if (checked) {
                    break;
                }
            }
        }
        System.out.println(checked ? "YES" : "NO");



        Picnic picnic = new Picnic(6, 10, "0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5".split(" "));

        int couple = picnic.countPairings(new boolean[6]);
        System.out.println(couple);




        BoardCover boardCover = new BoardCover();
        char[][] test = new char[][] {
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };
        int[][] boards = new int[8][10];
        for (int i = 0 ; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                boards[i][j] = (test[i][j] == '#') ? 1 : 0;
            }
        }

        int ans = boardCover.cover(boards);
        System.out.println(ans);
    }
    //1부터 n까지의 합을 계산하는 반복함수
    //필수조건 n >= 1
    //결과 : 1부터 n까지의 합 반환
    private static int sum(int n) {
        int ret = 0;
        for (int i = 1; i <= n; ++i) {
            ret += i;
        }
        return  ret;
    }
    //1부터 n까지의 합을 계산하는 재귀 함수
    //필수조건 n >= 1
    //결과 : 1부터 n까지의 합 반환
    private static int recursiveSum(int n) {
        if (n == 1) {
            return 1; //더 이상 쪼개지지 않을 때
        }
        return n + recursiveSum(n-1);
    }

    //n개의 원소 중 4개를 고르는 경우
    public static int sum4(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        count++;
                        System.out.println(i +", " + j +", " + k + ", " + l);
                    }
                }
            }
        }
        return count;
    }
    //n : 전체 원소 수
    //picked : 지금까지 고른 원소들의 번호
    //toPick : 몇개의 원소를 고를 수
    public static void pick(int n, Stack<Integer> picked, int toPick) {
        //더 고를 원소가 없을 때 고른 원소들을 출력
        if (toPick == 0) {
            System.out.println(picked);
            return;
        }
        //가장 작은 번호를 계산
        int smallest = picked.isEmpty() ? 0 : picked.peek() + 1;

        for (int next = smallest; next < n; ++next) {
            picked.push(next);
            pick(n, picked, toPick - 1);
            picked.pop();
        }
    }

    /**
     * 보글 게임
     * 5 X 5 크기 알파뱃 격자를 가지고 하는 게임
     * 상하좌우/대각선으로 인접한 칸들의 글자들을 이어서 단어를 찾아내는 것.
     * 각 글자들은 대각선으로도 이어질 수 있으며, 한 글자가 두 번 이상 사용될 수도 있음.
     * 주어진 칸에서 시작하여 특정 단어를 찾을 수 있는지 확인하는 문제
     * https://algospot.com/judge/problem/read/BOGGLE
     * O(8^n)
     * 단어의 길이가 짧을 때 완전 탐색으로 해결 가능.
     */
    private static class Boggle {
        private static final int[] DX = new int[]{-1, -1, -1, 1, 1, 1, 0, 0};
        private static final int[] DY = new int[]{-1, 0, -1, -1, 0, 1, -1, 1};

        public boolean hasWord(int y, int x, String word, String[][] board) {

            //1. 시작 위치가 범위 밖이면 무조건 실패
            if (isRange(y, x, board.length)) {
                return false;
            }
            //2. 첫 글자가 일치하지 않으면 실패
            if (board[y][x].charAt(0) != word.charAt(0)) {
                return false;
            }
            //단어길이가 1이면 성공 리턴
            if (word.length() == 1) {
                return true;
            }

            //인접한 여덟 칸을 검사
            for (int direction = 0 ; direction < 8; direction++) {
                int nextY = y + DY[direction];
                int nextX = x + DX[direction];
                //다음 칸 검사
                if (hasWord(nextY, nextX, word.substring(1), board)) {
                    return true;
                }
            }
            return false;
        }
        private boolean isRange(int y, int x, int length) {
            return (x < 0 || x >= length) || (y < 0 || y >= length);
        }
    }

    /**
     *소풍
     * 두명식 짝을만듬
     * 항상 서로 친구인 학생들끼리 짝
     * 짝이 되는 학생들이 일부만 다르더라도 다른방법.
     */
    private static class Picnic {

        private boolean[][] friends;
        private int n;
        public Picnic(int std, int couple, String[] matching) {
            this.n = std;
            this.friends = new boolean[couple][couple];
            for (int i = 0; i < matching.length - 1; i++) {
                int a = Integer.parseInt(matching[i]);
                int b = Integer.parseInt(matching[i+1]);
                friends[a][b] = true;
                friends[b][a] = true;
            }
        }

        public int countPairings(boolean[] taken) {
            //1.남은 학생들 중 가장 번호가 빠른 학생을 찾음
            int firstFree = -1;
            for (int i = 0; i < n; i++) {
                if (!taken[i]) {
                    firstFree = i;
                    break;
                }
            }

            //2. 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료
            if (firstFree == -1) {
                return 1;
            }

            int ret = 0;

            //해당 학생과 짝지을 학생을 결정
            for (int pairWith = firstFree + 1; pairWith < n; ++pairWith) {
                if (!taken[pairWith] && friends[firstFree][pairWith]) {
                    taken[firstFree] = taken[pairWith] = true;
                    ret += countPairings(taken);
                    taken[firstFree] = taken[pairWith] = false;
                }
            }
            return ret;
        }
    }

    public static class BoardCover {
        private static final int[][][] COVER_TYPE_YX = new int[][][] { //4,3,2
                {{0,0}, {1, 0}, {0,1}},
                {{0,0}, {0, 1}, {1,1}},
                {{0,0}, {1, 0}, {1,1}},
                {{0,0}, {1, 0}, {1,-1}}
        };
        //board의 (y,x)를 type 번 방법으로 덮거나, 덮었던 블록을 없앤다.
        //delta = 1 이면 덮고, -1이면 덮었던 블록을 없앤다.
        //만약 블록이 제대로 덮이지 않은경우(게임판 밖으로 나가거나,
        //겹치거나, 검은 칸을 덮을 때) false를 반환한다.
        public boolean set(int[][] board, int y, int x, int type, int delta) {
            boolean check = true;
            for (int i = 0; i < 3; i++) {
                int ny = y + COVER_TYPE_YX[type][i][0];
                int nx = x + COVER_TYPE_YX[type][i][1];
                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                    check = false;
                } else if ((board[ny][nx] += delta) > 1) {
                    check = false;
                }
            }
            return check;
        }

        //board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환
        //board[i][j] = 1 이면 덮인 칸 혹은 검은 칸
        //board[i][j] = 0 이면 덮이지 않은 칸
        public int cover(int[][] board) {
            //아직 채우지 못한 칸 중 가장 윗줄 왼쪽에 있는 칸을 찾는다.
            int y = -1;
            int x = -1;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) { //가장 먼저 덮을 칸 찾기
                        y = i;
                        x = j;
                        break;
                    }
                }
                if (y != -1) { //루프 탈출
                    break;
                }
            }

            //모든 칸이 채워졌으면 1을 반환
            if (y == -1) {
                return 1;
            }

            int ret = 0;

            for (int type = 0; type < 4; type++) {
                //만약 board[y][x]를 type 형태로 덮을 수 있으면 재귀 호출
                if (set(board, y, x, type, 1)) {
                    ret += cover(board);
                }
                //덮었던 블록을 치운다.
                set(board, y, x, type, -1);
            }
            return ret;
        }
    }
}

