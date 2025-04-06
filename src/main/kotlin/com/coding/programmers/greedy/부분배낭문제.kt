package com.coding.programmers.greedy

fun main() {
    val sol = 부분배낭문제()
    val result = sol.solution(
        arrayOf(
            intArrayOf(10, 19),
            intArrayOf(7, 10),
            intArrayOf(6, 10),
        ),
        15
    )
    println(result)

    val result2 = sol.solution(
        arrayOf(
            intArrayOf(10, 60),
            intArrayOf(20, 100),
            intArrayOf(30, 120),
        ),
        50
    )
    println(result2)
}
class 부분배낭문제 {
    data class Item(
        val value: Int,
        val weight: Int,
        val valuePerWeight: Double,
    )

    fun solution(items: Array<IntArray>, weight_limit: Int): Double {
        val itemArr = Array<Item>(items.size) { Item(items[it][1], items[it][0], items[it][1].toDouble() / items[it][0]) }
                    .sortedByDescending { it.valuePerWeight }

        var remainingWeight: Double = weight_limit.toDouble()
        var total = 0.0

        for (item in itemArr) {
            if (item.weight <= remainingWeight) {
                total += item.value
                remainingWeight -= item.weight
            } else {
                val fraction = remainingWeight / item.weight
                total += item.value * fraction
                break
            }
        }


        return total
    }

}