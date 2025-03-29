package com.coding.programmers.structure

import java.util.*

fun main() {
    val result = 프로세스().solution(
        intArrayOf(2, 1, 3, 2),
        2
    )
    println(result)
}
class 프로세스 {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue: Queue<Process> = LinkedList()

        for ((index, pri) in priorities.withIndex()) {
            queue.offer(Process(index, pri))
        }

        while (queue.isNotEmpty()) {
            val dq = queue.poll()

            if (queue.any { dq.priority < it.priority }) {
                println(dq)
                queue.offer(dq)
            } else {
                answer++
                if (dq.loc == location) break
            }
        }
        return answer
    }
    data class Process(
        val loc: Int,
        val priority: Int,
    )
}