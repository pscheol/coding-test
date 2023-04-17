package com.coding.programmers.level1;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {

    }
    public boolean solution(String s) {
        char[] chars = s.toCharArray();
        int p = 0;
        int y = 0;
        for (char ch : chars) {
            if (ch == 'P' || ch == 'p') {
                p++;
            } else if (ch == 'Y' || ch == 'y') {
                y++;
            }
        }
        return p == y;
    }
}
