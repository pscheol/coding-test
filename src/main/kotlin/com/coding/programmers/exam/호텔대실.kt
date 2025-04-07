package com.coding.programmers.exam

import java.util.*

fun main() {
    val sol = 호텔대실()
    val result = sol.solution(arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20")
    ))
    println(result)
}

class 호텔대실 {
    fun solution(book_time: Array<Array<String>>): Int {
        val bookTime = book_time.map { book -> Pair(toLocalTime(book[0]), toLocalTime(book[1]).plus(10)) }
            .sortedBy { it.first }

        val pq = PriorityQueue<Int>() // 최소 힙 (퇴실+청소 시간 기준)

        for ((start, end) in bookTime) {
            if (pq.isNotEmpty() && pq.peek() <= start) {
                pq.poll()
            }
            pq.add(end)
        }

        return pq.size
    }
    private fun toLocalTime(time: String): Int {
        val (hour, minute) = time.split(":").map { it.toInt() }
        return (hour * 60) + minute
    }
}