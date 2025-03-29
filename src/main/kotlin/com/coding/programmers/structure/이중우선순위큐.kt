package com.coding.programmers.structure

import java.util.*
import kotlin.math.max
import kotlin.math.min


fun main() {
//    println(이중우선순위큐().solution(arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")).contentToString())
    println(이중우선순위큐().solution(arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")).contentToString())

}
class 이중우선순위큐 {
    fun solution(operations: Array<String>): IntArray {
        val maxQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 } //max
        val minQueue = PriorityQueue<Int> { o1, o2 -> o1 - o2 } //min

        for (operation in operations) {
            val token = StringTokenizer(operation, " ")
            val op = token.nextToken()
            val num = token.nextToken().toInt()
            if (op == "I") {
                maxQueue.offer(num)
                minQueue.offer(num)
            } else {
                if (num  == -1 && minQueue.isNotEmpty()) { //min
                    maxQueue.remove(minQueue.poll())
                } else { //max
                    minQueue.remove(maxQueue.poll())
                }
            }
        }

        if (maxQueue.isEmpty() && minQueue.isEmpty()) {
            return intArrayOf(0, 0)
        }
        return intArrayOf(maxQueue.poll(), minQueue.poll())
    }
}