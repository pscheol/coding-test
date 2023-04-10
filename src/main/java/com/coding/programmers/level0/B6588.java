package com.coding.programmers.level0;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class B6588 {



    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        String MESSAGE = "Goldbach's conjecture is wrong.\n";
        Map map;

        boolean[] check = prime(1000000);
        int n  = 0;
        boolean flag = false;
        while ((n = Integer.parseInt(r.readLine())) != 0) {
            flag = false;
            for (int i = 2; i < n; i++) {
                if (!check[i] && (!check[i] && !check[n - i])) {
                    w.write(n + " = " + i + " + " + (n - i) + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                w.write(MESSAGE);
            }
            w.flush();
        }
        r.close();
        w.close();
    }
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for (int i = num_list.length; i > 0; i--) {
            answer[num_list.length - i] = num_list[i];
        }
        return answer;
    }
    public int[] sol1(int[] numList) {
        List<Integer> list = Arrays.stream(numList).boxed().collect(Collectors.toList());

        Collections.reverse(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int[] numbers(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        Arrays.sort(numbers);
        return answer;
    }
    private static boolean[] prime(int n) {
        boolean[] check = new boolean[n + 1];
        check[0] = check[1] = true;

        for (int i = 2; i < n; i++) {
            if (!check[i]) {
                for (int j = i + i; j < n; j+=i) {
                    check[j] = true;
                }
            }
        }
        return check;
    }
}
