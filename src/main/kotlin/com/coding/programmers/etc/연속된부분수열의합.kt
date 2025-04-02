package com.coding.programmers.etc

fun main() {
    val result = 연속된부분수열의합().solution(intArrayOf(1,2,3,4,5), 7)
    println(result.contentToString())

    val result3 = 연속된부분수열의합().solution(intArrayOf(1, 1, 1, 2, 3, 4, 5), 5)
    println(result3.contentToString())

    val result2 = 연속된부분수열의합().solution(intArrayOf(2, 2, 2, 2, 2), 6)
    println(result2.contentToString())

}
class 연속된부분수열의합 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val answer = intArrayOf(0, 0)
        val n = sequence.size
        var left = 0
        var right = 0
        var currentSum = sequence[0]
        var bestLength = Int.MAX_VALUE

        while(right < n) {
            if (currentSum == k) {
                val currentLength = right - left + 1

                if (currentLength < bestLength) {
                    bestLength = currentLength
                    answer[0] = left
                    answer[1] = right
                }
                currentSum -= sequence[left]
                left++
            } else if (currentSum < k) {
                right++
                if (right < n) {
                    currentSum += sequence[right]
                }
            } else { //currentSum > k
                currentSum -= sequence[left++]
            }
        }
        return answer
    }
}