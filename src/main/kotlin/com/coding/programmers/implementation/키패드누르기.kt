package com.coding.programmers.implementation

import kotlin.math.abs

fun main() {
    val result = 키패드누르기().solution(
        intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"
    )
    println(result)
}

/**
 * LRLLLRLLRRL
 * LRLLRRLLLRR
 */
class 키패드누르기 {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var left = 10
        var right = 12

        for (number in numbers) {
            if (number == 1 || number == 4 || number == 7) {
                left = number
                answer+= "L"
            } else if (number == 3 || number == 6 || number == 9) {
                right = number
                answer+= "R"
            } else {
                val leftHand = find(number, left)
                val rightHand = find(number, right)
                println("$leftHand, $rightHand")
                if (leftHand == rightHand) {
                    if (hand == "left") {
                        left = number
                        answer+= "L"
                    } else {
                        right = number
                        answer+= "R"
                    }
                } else {
                    if (leftHand < rightHand) {
                        left = number
                        answer+= "L"
                    } else {
                        right = number
                        answer+= "R"
                    }
                }
            }
        }
        return answer
    }
    fun find(src: Int, hand: Int): Int {
        val num = if (src == 0) 11 else src
        val handNum = if (hand == 0) 11 else hand
        val checkNum = abs(num - handNum)
        println("$src, $hand, = $checkNum")
        return (checkNum / 3) + (checkNum % 3)
    }
}