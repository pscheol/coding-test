package com.coding.programmers.sorting

fun main() {
    val r = H_Index().solution(intArrayOf(3,0,6,1,5))
    println(r)
}
class H_Index {
    fun solution(citations: IntArray): Int {
        val n = citations.size
        citations.sortDescending()
        for (i in citations.indices) {
            println("citations[i] = ${citations[i]} < i + 1 = ${i + 1}")
            if (citations[i] < i + 1) {
                return i
            }
        }
        return citations.size
    }
}