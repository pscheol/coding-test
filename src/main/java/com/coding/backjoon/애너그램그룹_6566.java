package com.coding.backjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 애너그램그룹_6566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> argList = new ArrayList<>();

        while (true) {
            String data = br.readLine();
            if (data == null || data.length() <= 0 || data.equals("EOF")) {
                break;
            }
            argList.add(data);
        }

        Map<String, List<String>> groupMap = new HashMap<>();

        for (String data : argList) {
            char[] dataChar = data.toCharArray();
            Arrays.sort(dataChar);
            String dataOrder = Arrays.toString(dataChar);

            List<String> sub = groupMap.getOrDefault(dataOrder, new ArrayList<>());
            sub.add(data);
            groupMap.put(dataOrder, sub);
        }


        List<List<String>> result = groupMap.values()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.size() == o2.size()) {
                        return o1.get(0).compareTo(o2.get(0));
                    } else {
                        return o1.size() > o2.size() ? -1 : 0;
                    }
                })
                .collect(Collectors.toList());


        for (int i = 0; i < result.size(); i++) {
            List<String> list = result.get(i).stream().distinct().sorted().collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            sb.append("Group of size ");
            sb.append(result.get(i).size());
            sb.append(": ");
            sb.append(String.join(" ", list));
            sb.append(" .");
            bw.write(sb.toString());
            if (i == 4) {
                break;
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
