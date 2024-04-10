package com.coding.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴팰린드롬부분문자열_14444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();


        //#a#c#c#a 변환
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() -1; i >= 0; i--) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");

        int[] A = manacher(sb.toString());
        int answer = 0;

        for (int v : A) {
            answer = Math.max(answer, v);
        }

        System.out.println(answer);

        br.close();
    }
    private static int[] manacher(String s) {
        int[] A = new int[s.length()];
        int p = -1; //가장 긴 팰린드롬의 중심 인덱스
        int R = -1; //가장긴 팰린드롬의 우축 끝 인덱스
        int n = s.length();

        for (int i = 0; i < n; i++) {
            //이미 팰린드롬이라고 정해져 있는 인덱스에 속해져있는지
            if (i <= R) {
                A[i] = Math.min(A[2 * p - i], R - i);
            } else {
                A[i] = 0;
            }
            //양끝 인덱스가 배열에서 벗어나지 않고 && 문자가 같다면 팰린드롬에 추가(좌측(i - A[i] - 1)만큼 우측(i + A[i] + 1)인덱스 값에 값이 맞는지
            while ((i - A[i] - 1 >= 0) && (i + A[i] + 1 < n) && s.charAt(i - A[i] - 1) == s.charAt(i + A[i] + 1)) {
                A[i]++;
            }

            if ((i + A[i]) > R) {
                R = (i + A[i]);
                p = i;
            }
        }
        return A;
    }
}
