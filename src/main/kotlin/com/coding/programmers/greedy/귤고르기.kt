package com.coding.programmers.greedy

fun main() {
    val sol = 귤고르기()
    val r = sol.solution(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))
    println(r)
    val r2 = sol.solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))
    println(r2)
    val r3 = sol.solution(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3))
    println(r3)
}

class 귤고르기 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        val bucket = HashMap<Int, Int>()
        var sum = 0
        for (t in tangerine) {
            bucket[t] = (bucket[t]?: 0) + 1
        }
        for (value in bucket.values.sortedDescending()) {
            answer++
            sum += value
            if (sum >= k) {
                break
            }
        }

        return answer
    }
}