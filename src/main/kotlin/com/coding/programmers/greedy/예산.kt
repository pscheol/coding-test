package com.coding.programmers.greedy

fun main() {
    println(예산().solution(intArrayOf(1,3,2,5,4), 9))
    println(예산().solution(intArrayOf(2,2,3,3), 10))
}
class 예산 {
    fun solution(d: IntArray, budget: Int): Int {
        var answer = 0
        var budget_tmp = budget
        d.sorted().forEach {
            if (it <= budget_tmp) {
                answer++
                budget_tmp -= it
            }
        }

        return answer
    }
}