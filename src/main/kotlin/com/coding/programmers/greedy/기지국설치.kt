package com.coding.programmers.greedy

fun main() {
    val sol = 기지국설치()
    val r = sol.solution(11, intArrayOf(4, 11), 1)
    val r2 = sol.solution(16, intArrayOf(9), 2)
    println(r)
    println(r2)


}
class 기지국설치 {
    fun solution(n: Int, stations: IntArray, w: Int): Int {
        var answer = 0
        var loc = 0
        var idx = 0
        while (loc <= n) {
            if (idx < stations.size && loc >= stations[idx] - w) {
                loc = stations[idx] + w + 1
                idx++
            } else {
                loc += 2 * w + 1
                answer++
            }
        }
        return answer
    }
}