package com.coding.etc;

import java.util.Arrays;

public class 트리순회 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.solution(new int[]{1,2,3,4,5,6,7});
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        public String[] solution(int[] nodes) {
            String[] answer = new String[3];
            answer[0] = preorder(nodes, 0).trim();
            answer[1] = inorder(nodes, 0).trim();
            answer[2] = postorder(nodes, 0).trim();
            return answer;
        }


        /**
         * root -> left -> right
         * @param nodes
         * @param start
         * @return
         */
        private String preorder(int[] nodes, int start) {
            if (start >= nodes.length) {
                return "";
            }

            return nodes[start] + " " + preorder(nodes, start * 2 + 1) + preorder(nodes, start * 2 + 2);
        }

        /**
         *  left -> root -> right
         * @param nodes
         * @param start
         * @return
         */
        private String inorder(int[] nodes, int start) {
            if (start >= nodes.length) {
                return "";
            }

            return inorder(nodes, start * 2 + 1) + nodes[start] + " " + inorder(nodes, start * 2 + 2);
        }

        /**
         * left -> right -> root
         * @param nodes
         * @param start
         * @return
         */
        private String postorder(int[] nodes, int start) {
            if (start >= nodes.length) {
                return "";
            }

            return postorder(nodes, start * 2 + 1) + postorder(nodes, start * 2 + 2) + nodes[start] + " ";
        }
    }
}
