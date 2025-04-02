package com.coding.programmers.etc

fun main() {
    val r = ExamT1().solution(intArrayOf(1,3,6,4,2,1))
    println(r)
    val r2 = ExamT1().solution(intArrayOf(1,2,3))
    println(r2)
    val r3 = ExamT1().solution(intArrayOf(-1, -3))
    println(r3)
}
class ExamT1 {
    fun solution(A: IntArray): Int {
        val set = HashSet<Int>()
        A.forEach { set.add(it) }

        var smallestMissing = 1
        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }
        while (smallestMissing in set) {
            smallestMissing++
        }

        return smallestMissing
    }
}