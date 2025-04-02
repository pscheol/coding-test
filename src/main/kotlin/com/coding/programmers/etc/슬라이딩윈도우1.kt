package com.coding.programmers.etc

import kotlin.math.max


fun main() {
    val r = 슬라이딩윈도우1().solution(intArrayOf(3, -7, 3, -7, 3))
    println(r)
    val r2 = 슬라이딩윈도우1().solution(intArrayOf(7, 4, -2, 4, -2, -9))
    println(r2)
    val r3 = 슬라이딩윈도우1().solution(intArrayOf(7, -5 ,-5 ,-5 ,7, -1, 7))
    println(r3)
    val r4 = 슬라이딩윈도우1().solution(intArrayOf(4))
    println(r4)


}
class 슬라이딩윈도우1 {
    fun solution1(A: IntArray): Int {
        val n = A.size
        if (n == 1) return 1 // 배열 길이가 1이면 무조건 스위칭 상태


        var maxLen = 1
        var left = 0 // 스위칭 시작 인덱스

        for (right in 1..<n) {
            // 현재 위치에서 스위칭 규칙이 깨지는 경우
            if (right >= 2 && (A[right] != A[right - 2])) {
                left = right - 1 // 새로운 스위칭 시작점
            }
            maxLen = max(maxLen, (right - left + 1))
        }

        return maxLen
    }


    fun solution(A: IntArray): Int {
        val n = A.size
        if (n == 1) return 1

        var maxLength = 1
        var even = A[0]
        var odd = A[1]
        var left = 0

        for (right in 1 until n) {
            if (right % 2 == 0) { //even
                if (A[right] != even) {
                    left = right - 1
                }
                even = A[right]
            } else { //odd
                if (A[right] != odd) {
                    left = right -1
                }
                odd = A[right]
            }

            maxLength = max(maxLength, right - left + 1)
        }

        return maxLength

    }
}