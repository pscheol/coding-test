package com.coding.programmers.etc

fun main() {
    val result = 연속된수의합().solution(3, 12)
    println(result.contentToString())
    val result2 = 연속된수의합().solution(5, 15)
    println(result2.contentToString())

    val result3 = 연속된수의합().solution(4, 14)
    println(result3.contentToString())
    val result4 = 연속된수의합().solution(5, 5)
    println(result4.contentToString())
}
class 연속된수의합 {
    fun solution(num: Int, total: Int): IntArray {
        var answer: IntArray = IntArray(num)
        val s = ((total * 2) / num - (num - 1)) / 2
        println("S = $s")
        for (i: Int in 0 until num) {
            answer[i] = s + i
        }
        return answer
    }
}