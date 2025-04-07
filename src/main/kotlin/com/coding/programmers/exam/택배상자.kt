package com.coding.programmers.exam

import java.util.Stack
fun main() {
    println(택배상자().solution(intArrayOf(4, 3, 1, 2, 5)))
}
class 택배상자 {
    fun solution(order: IntArray): Int {
        val subBelt = Stack<Int>()
        var idx = 0
        var box = 1
        while (box <= order.size) {
            if (box == order[idx]) {
                idx++
                box++
            } else if (subBelt.isNotEmpty() && subBelt.peek() == order[idx]) {
                idx++
            } else {
                subBelt.push(box++)
            }
        }

        while (subBelt.isNotEmpty() && subBelt.peek() == order[idx]) {
            subBelt.pop()
            idx++
        }
        return idx
    }
}