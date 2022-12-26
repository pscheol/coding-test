package coding.programmers.level0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> L = new Stack<>();
        Stack<Character> D = new Stack<>();


        String s1 = in.readLine();

        for (char ch : s1.toCharArray()) {
            L.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- != 0) {
            String cmd = in.readLine();
            if (cmd.charAt(0) == 'P') {
                char ch = cmd.charAt(2);
                L.push(ch);
            } else if (cmd.charAt(0) == 'L') {
                if (!L.isEmpty()) {
                    D.push(L.pop());
                }
            } else if (cmd.charAt(0) == 'D') {
                if (!D.isEmpty()) {
                    L.push(D.pop());
                }
            } else if (cmd.charAt(0) == 'B') {
                if (!L.isEmpty()) {
                    L.pop();
                }
            }
        }

        while (!L.isEmpty()) {
            D.push(L.pop());
        }

        while (!D.isEmpty()) {
            sb.append(D.pop());
        }
        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
    public void seq() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int m = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (n-- != 0) {
            int s = Integer.parseInt(in.readLine());
            if (s > m) {
                while (s > m) {
                    stack.push(++m);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (!stack.isEmpty()) {
                    int p = stack.pop();
                    if (p == s) {
                        sb.append("-\n");
                    } else {
                        m = -1;
                        break;
                    }
                }
            }
        }
        if (m != -1) out.write(sb.toString());
        else out.write("NO");
        out.flush();
        out.close();
        in.close();
    }
}
