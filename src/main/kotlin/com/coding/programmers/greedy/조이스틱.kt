package com.coding.programmers.greedy

fun main() {
    조이스틱().solution("JEROEN")
    조이스틱().solution("JAN")
    조이스틱().solution("JAZ")

}
class 조이스틱 {
    fun solution(name: String): Int {
        var answer = 0
        val chars = name.toCharArray()
        // ▲ ▼ 조작 횟수 계산
        for (ch in chars) {
            answer += minOf(ch - 'A', 'Z'- ch + 1)
        }
        // ◀ ▶ 최소 이동 거리 계산
        var move = name.length - 1
        val len = name.length
        for (i : Int in 0 until len) {
            var next = i + 1
            while(next < len && name[next] == 'A') {
                println("next=$next, len=$len")
                println("${name[next] == 'A'}= ${name[next]}")
                next++
            }

            move = minOf(move, i + len - next + minOf(i , len - next))
        }
        answer += move
        return answer
    }
}