package com.coding.programmers.graph.dfs

import java.util.Stack

fun main() {
    val r = 네트워크().solution(3, arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1),
    ))
    println(r)
}
class 네트워크 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = mutableSetOf<Int>()
        var answer = 0
        computers.forEachIndexed { vertex, computer ->
            if (!visited.contains(vertex)) {
                dfs(computers, visited, vertex)
                answer++
            }
        }

        return answer
    }

    fun dfs(computers: Array<IntArray>, visited:MutableSet<Int> ,vertex: Int) {
        val stack = Stack<Int>()
        stack.push(vertex)

        while (stack.isNotEmpty()) {
            val popV = stack.pop()

            computers[popV].forEachIndexed { i, v ->
                if (v == 1 && !visited.contains(i)) {
                    visited.add(i)
                    stack.push(i)
                }
            }
        }
    }

}