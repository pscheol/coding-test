package com.coding.programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 캐시 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, new String[] {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        }));
        System.out.println(sol.solution(3, new String[] {
                "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
        }));
        System.out.println(sol.solution(2, new String[] {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        }));
        System.out.println(sol.solution(5, new String[] {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        }));
        System.out.println(sol.solution(2, new String[] {
                "Jeju", "Pangyo", "NewYork", "newyork"
        }));
        System.out.println(sol.solution(0, new String[] {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        }));

    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) {
                return cities.length * 5;
            }

            Deque<String> cache = new ArrayDeque<>();
            int answer = 0;
            for (String city : cities) {
                String lowerCity = city.toLowerCase();
                if (cache.contains(lowerCity)) {
                    //cacheHit
                    cache.remove(lowerCity);
                    cache.addFirst(lowerCity);
                    answer += 1;
                } else {
                    //cache Miss
                    if (cache.size() == cacheSize) {
                        cache.removeLast();
                    }
                    cache.addFirst(lowerCity);
                    answer += 5;
                }
            }

            return answer;
        }

    }
}
