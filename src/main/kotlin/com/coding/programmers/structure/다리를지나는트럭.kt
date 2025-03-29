package com.coding.programmers.structure


import java.util.LinkedList
import java.util.Queue

fun main() {
    println(다리를지나는트럭().solution(2, 10 , intArrayOf(7,4,5,6)))
}
class 다리를지나는트럭 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val bridgeQueue:Queue<Int> = LinkedList(List(bridge_length){0})
        val waitQueue:Queue<Int> = LinkedList(truck_weights.toList())

        while (bridgeQueue.isNotEmpty()) {
            answer++
            bridgeQueue.poll()
            if (waitQueue.isNotEmpty()) {
                if (bridgeQueue.sum() + waitQueue.peek() <= weight) {
                    bridgeQueue.offer(waitQueue.poll())
                } else {
                    bridgeQueue.offer(0)
                }
            }
        }

        return answer
    }
}