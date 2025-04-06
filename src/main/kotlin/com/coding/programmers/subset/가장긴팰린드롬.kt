package com.coding.programmers.subset

fun main() {
    println(가장긴팰린드롬().solution("abcdcba"))
    println(가장긴팰린드롬().solution("abacde"))
}
class 가장긴팰린드롬 {
    fun solution(s: String): Int {
        var answer = 1

        for (i in 0..s.length) {
            var count = 0
            while ((i - count) >= 0 && (i + count) < s.length) {
                if (s[i-count] != s[i+count]) {
                    break;
                }
                count++
            }
            answer = maxOf(answer, count * 2 - 1)

            count = 0
            while((i - count) >= 0 && (i + count + 1) < s.length) {
                if (s[i-count] != s[i+count + 1]) {
                    break;
                }
                count++
            }
            answer = maxOf(answer, count * 2)
        }

        return answer
    }
}