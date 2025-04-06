package com.coding.programmers.greedy

fun main() {
    val result = 구명보트().solution(intArrayOf(70, 50, 80, 50),100)
    println(result)
    val result2 = 구명보트().solution(intArrayOf(70, 80, 50),100)
    println(result2)
}

class 구명보트 {
    fun solution(people: IntArray, limit: Int): Int {
        var answer = 0
        val p = people.sortedArray()
        var left = 0
        var right = p.size - 1
        while (left <= right) {
            if (p[left] + p[right] <= limit) {
                left++
            }
            right--
            answer++
        }

        return answer
    }
}