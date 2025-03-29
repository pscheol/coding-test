package com.coding.programmers.implementation

fun main() {
    val result = 숫자문자열과영단어().solution("one4seveneight")
    println(result)

}
class 숫자문자열과영단어 {
    fun solution(s: String): Int {
        val sb = StringBuilder()
        val disit = mapOf(
            "zero" to 0,"one" to 1,"two" to 2,"three" to 3,"four" to 4,
            "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
        )

        var numStr =""
        for ((index, ch) in s.toCharArray().withIndex()) {
            numStr += ch;

            val num = disit.getOrDefault(numStr, -1)
            if (ch.isDigit() || num != -1) {
                sb.append(if (ch.isDigit()) ch.digitToInt() else num)
                numStr = ""
            }
        }
        return sb.toString().toInt()
    }
}