package com.coding.programmers.level3;

import java.util.*;

public class 단어변환 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("hit", "cog", new String[]{
                "hot", "dot", "dog", "lot", "log", "cog"
        }));
    }
    private static class Solution {
        public int solution(String begin, String target, String[] words) {
            Queue<Node> queue = new ArrayDeque<>();
            Set<String> distSet = new HashSet<>();
            queue.add(new Node(begin, 0));
            distSet.add(begin);

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (target.equals(now.word)) {
                    return now.weight;
                }

                for (String word : words) {
                    if (!distSet.contains(word) && now.compareWith(word)) {
                        queue.offer(new Node(word, now.weight + 1));
                        distSet.add(word);
                    }
                }
            }
            return 0;
        }

        private static class Node {
            String word;
            int weight;

            public Node(String word, int weight) {
                this.word = word;
                this.weight = weight;
            }

            public boolean compareWith(String target) {
                int count = 0;

                for (int i = 0; i < this.word.length(); i++) {
                    if (this.word.charAt(i) != target.charAt(i) && ++count > 1) {
                        break;
                    }

                }
                return count == 1;
            }
        }
    }
}
