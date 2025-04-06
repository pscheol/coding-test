package com.coding.programmers.greedy

import java.util.Stack

fun main() {
    val sol = 큰수만들기()
    val r = sol.solution("1924", 2)
    println(r)
    val r2 = sol.solution("1231234", 3)
    println(r2)
    val r3 = sol.solution("4177252841", 4)
    println(r3)
}
class 큰수만들기 {
    fun solution(number: String, k: Int): String {
        val chars = number.toCharArray()
        var length = chars.size - k
        val stack = Stack<Char>()
        val sb = StringBuilder()
        var kk = k

        for (ch in chars) {
            while (stack.isNotEmpty() && stack.peek() < ch && kk-- > 0) {
                stack.pop()
            }
            stack.push(ch)
        }

        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }

        if (kk > 0) {
            return sb.reverse().toString().substring(0, sb.toString().length - kk)
        }

        return sb.reverse().toString()
    }
}