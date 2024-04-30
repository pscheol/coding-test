package com.coding.programmers.level2.tree;

import java.util.*;

/**
 * 조직 내 누가 얼마만큼의 이득을 가져갔는지 궁굼
 * [분배규칙]
 * 모든 판매원은 칫솔판매 이익 10% 계산하여 자신의 조직에 참여시킨 추천인에게 배분 후 나머지는 자신이 가진다.
 * 모든 판매원은 칫솔 판매에서 발생한 이익 뿐만 아니라, 자신의 조직에 추천하여 가입시킨 판매원에게서 발생하는 이익의 10%까지 자신의 이익
 * 자신에게 발생하는 이익 또한 마찬가지 규칙으로 추천인에게 분배. 단, 10% 계산할 때 원 단위에서 절사, 10%를 계산한 금액이 1원미만일 경우 분배하지 않고 자신이 가짐
 *
 *
 */
public class 다단계칫솔판매 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
                );
        System.out.println(Arrays.toString(result));

        Solution2 sol2 = new Solution2();
        int[] result2 = sol2.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        );
        System.out.println(Arrays.toString(result2));

    }

    /**
     * 테스트 1 〉	통과 (0.09ms, 77.7MB)
     * 테스트 2 〉	통과 (0.19ms, 73MB)
     * 테스트 3 〉	통과 (0.17ms, 74MB)
     * 테스트 4 〉	통과 (0.50ms, 71MB)
     * 테스트 5 〉	통과 (1.86ms, 80.7MB)
     * 테스트 6 〉	통과 (4.37ms, 104MB)
     * 테스트 7 〉	통과 (4.59ms, 99.9MB)
     * 테스트 8 〉	통과 (4.92ms, 101MB)
     * 테스트 9 〉	통과 (22.36ms, 110MB)
     * 테스트 10 〉	통과 (61.33ms, 129MB)
     * 테스트 11 〉	통과 (41.47ms, 136MB)
     * 테스트 12 〉	통과 (56.26ms, 140MB)
     * 테스트 13 〉	통과 (38.72ms, 143MB)
     */
    private static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map<String, String> parent = new HashMap<>();

            for (int i = 0; i < enroll.length; i++) {
                parent.put(enroll[i], referral[i]);
            }

            Map<String, Integer> total = new HashMap<>();
            for (int i = 0; i < seller.length; i++) {
                String sellerName = seller[i];
                int totalAmount = amount[i] * 100; //판매 개수 * 100
                while (totalAmount > 0 && !"-".equals(sellerName)) {
                    total.put(sellerName, (total.getOrDefault(sellerName, 0) + totalAmount - (totalAmount / 10)));
                    sellerName = parent.get(sellerName);
                    totalAmount /= 10;
                }
            }

            int[] answer = new int[enroll.length];
            for (int i = 0; i < enroll.length; i++) {
                answer[i] = total.getOrDefault(enroll[i], 0);
            }
            return answer;
        }
    }

    /**
     * 테스트 1 〉	통과 (0.28ms, 75.3MB)
     * 테스트 2 〉	통과 (0.46ms, 72.1MB)
     * 테스트 3 〉	통과 (0.40ms, 76.2MB)
     * 테스트 4 〉	통과 (0.37ms, 86.8MB)
     * 테스트 5 〉	통과 (0.82ms, 79.7MB)
     * 테스트 6 〉	통과 (9.55ms, 104MB)
     * 테스트 7 〉	통과 (9.10ms, 102MB)
     * 테스트 8 〉	통과 (6.38ms, 101MB)
     * 테스트 9 〉	통과 (16.20ms, 104MB)
     * 테스트 10 〉	통과 (21.18ms, 122MB)
     * 테스트 11 〉	통과 (6917.14ms, 114MB)
     * 테스트 12 〉	통과 (2955.33ms, 133MB)
     * 테스트 13 〉	통과 (6172.36ms, 124MB)
     */
    private static class Solution2 {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map<String, Seller> parent = new HashMap<>();

            for (int i = 0; i < enroll.length; i++) {
                String enr = enroll[i];
                String ref = referral[i];
                Seller refSeller = parent.getOrDefault(ref, new Seller(ref));
                if (!parent.containsKey(enr)) {
                    parent.put(enr, new Seller(enr, refSeller));
                }
            }

            for (int i = 0; i < seller.length; i++) {
                parent.get(seller[i]).reward(100 * amount[i]);
            }

            int[] answer = new int[enroll.length];
            for (int i = 0; i < enroll.length; i++) {
                answer[i] = parent.get(enroll[i]).amount;
            }
            return answer;
        }

        class Seller {
            String name;
            Seller parent;
            int amount;

            public Seller(String name) {
                this.name = name;
                this.parent = null;
                this.amount = 0;
            }

            public Seller(String name, Seller parent) {
                this.name = name;
                this.parent = parent;
                this.amount = 0;
            }

            void reward(int amount) {
                int parentAmount = amount / 10;
                this.amount += amount - (parentAmount);
                if (this.parent != null)
                    this.parent.reward(parentAmount);
            }
        }
    }
}
