package com.coding.programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(sol.solution(100, 100, new int[]{10}));
        System.out.println(sol.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));


        Solution2 sol2 = new Solution2();
        System.out.println(sol2.solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(sol2.solution(100, 100, new int[]{10}));
        System.out.println(sol2.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    private static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int sum = 0;
            ArrayDeque<Integer> truckQueue = new ArrayDeque<>();

            for (int truck : truck_weights) {
                while(true) {
                    // 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리위에 없음
                    if(truckQueue.isEmpty()) {
                        truckQueue.offer(truck);
                        sum += truck;
                        answer++; // 다리에 오르면 시간 추가
                        break;
                    } else if(truckQueue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                        sum -= truckQueue.poll();
                    } else { // 다리 길이만큼 큐가 차지않았음
                        // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                        if(sum + truck <= weight) {
                            truckQueue.add(truck);
                            sum += truck;
                            answer++;
                            break;
                        } else {
                            // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
                            truckQueue.add(0);
                            answer++;
                        }
                    }
                }
            }

            // 마지막 트럭에서 반복문이 끝나므로 마지막 다리 길이만큼 지나가야함 + 다리 길이
            return answer + bridge_length;
        }
    }
    private static class Solution2 {
        public int solution(int bridgeLength, int weight, int[] truckWeights) {
            Queue<Truck> truckWeightQueue = new ArrayDeque<>();
            Queue<Truck> processQueue = new ArrayDeque<>();

            for (int truck : truckWeights) {
                truckWeightQueue.offer(new Truck(truck));
            }

            int answer = 0;
            int curWeight = 0;

            while (!truckWeightQueue.isEmpty() || !processQueue.isEmpty()) {
                answer++;

                if (processQueue.isEmpty()) {
                    Truck truck = truckWeightQueue.poll();
                    curWeight += truck.weight;
                    processQueue.offer(truck);
                    continue;
                }

                for (Truck truck : processQueue) {
                    truck.moving();
                }
                if (!processQueue.isEmpty() && processQueue.peek().move > bridgeLength) {
                    Truck truck = processQueue.poll();
                    curWeight -= truck.weight;
                }

                if (!truckWeightQueue.isEmpty() && curWeight + truckWeightQueue.peek().weight <= weight) {
                    Truck truck = truckWeightQueue.poll();
                    curWeight += truck.weight;
                    processQueue.offer(truck);
                }
            }

            return answer;
        }

        static class Truck {
            int weight;
            int move;

            public Truck(int weight) {
                this.weight = weight;
                this.move = 1;
            }

            public void moving() {
                move++;
            }
        }
    }
}
