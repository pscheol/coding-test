package com.coding.programmers.subset

fun main() {
    val result = 연속부분수열합의개수().solution(intArrayOf(7,9,1,1,4))
    println(result)
}
class 연속부분수열합의개수 {

    fun solution2(elements: IntArray): Int {
        val subset = mutableSetOf<Int>()
        val extendElements: IntArray = elements + elements

        for (length in 1..elements.size) {
            var curSum = elements.take(length).sum()
            subset.add(curSum)
            for (i in 1 until elements.size) {
                println(i + length - 1)
                curSum = curSum - extendElements[i - 1] + extendElements[i + length - 1]
                subset.add(curSum)
            }
        }

        return subset.size
    }
    fun solution(elements: IntArray): Int {
        val subset = HashSet<Int>()
        val n = elements.size
        val circleSeq = IntArray(n * 2) { elements[it % n] }

        for (window in 1..n) {
            for (start: Int in 0 until n) {
                var sum = 0
                for (left: Int in start until start + window) {
                    sum += circleSeq[left]
                }
                subset.add(sum)
            }
        }
        return subset.size
    }
}