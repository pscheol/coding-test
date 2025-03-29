package com.coding.programmers.sorting

fun main() {
    val r = K번째수().solution(
        intArrayOf(
            1, 5, 2, 6, 3, 7, 4
        ),
        arrayOf(
            intArrayOf(2,5,3),
            intArrayOf(4,4,1),
            intArrayOf(1,7,3),
        )
    );
    println(r.contentToString())
}
class K번째수 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.sliceArray(IntRange(it[0] - 1, it[1] - 1)).sortedArray()[it[2] -1]
        }.toIntArray()
    }

    fun solution2(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)

        for ((idx, command) in commands.withIndex()) {
            val i = command[0]
            val j = command[1]
            val k = command[2]
            answer[idx] = array.copyOfRange(i - 1, j).sortedArray()[k-1]
        }
        return answer
    }
}