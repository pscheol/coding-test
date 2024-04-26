package com.coding.programmers.level2;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        public String[] solution(String[] record) {
            Map<String, String> userMap = new HashMap<>();
            Map<String, String> message = new HashMap<>();
            message.put("Enter", "님이 들어왔습니다.");
            message.put("Leave", "님이 나갔습니다.");

            
            for (String s : record) {
                StringTokenizer token = new StringTokenizer(s, " ");
                String cmd = token.nextToken();
                if ("Enter".equals(cmd) || "Change".equals(cmd)) {
                    String uid = token.nextToken();
                    String nickname = token.nextToken();
                    userMap.put(uid, nickname);
                }
            }

            List<String> answer = new ArrayList<>();

            for (String s : record) {
                StringTokenizer token = new StringTokenizer(s, " ");
                String cmd = token.nextToken();
                if (message.containsKey(cmd)) {
                    String uid = token.nextToken();
                    answer.add(userMap.get(uid) + message.get(cmd));
                }
            }
            return answer.toArray(new String[0]);
        }
    }
}
