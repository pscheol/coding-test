package com.coding.programmers.graph.dfs
fun main() {
    val r = 타겟넘버().solution(intArrayOf(
        1,1,1,1,1
    ), 3)

    println(r)
}
class 타겟넘버 {
    fun solution2(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) {
            list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }

    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(0, 0, numbers, target)
    }
    fun dfs(sum: Int, idx: Int, nums:IntArray, target: Int) : Int {
        if (idx == nums.size && sum == target) {
            return 1
        }
        if (idx >= nums.size) {
            return 0
        }
        return dfs(sum + nums[idx], idx + 1, nums, target) + dfs(sum - nums[idx], idx + 1, nums, target)
    }
}