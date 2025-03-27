class Backtracking {
    lateinit var answer: ArrayList<IntArray>
    fun solution(n: Int): ArrayList<IntArray> {
        answer = ArrayList<IntArray>()

        backtrack(0, ArrayList<Int>(), 1, n)

        return answer
    }

    private fun backtrack(sum: Int, selectedNum: ArrayList<Int>, start: Int, n: Int) {
        println("backtrack : start=$start, sum=$sum, selectedNum=$selectedNum")
        if (sum == 10) {
            answer.add(selectedNum.toIntArray())
            return
        }

        for (i: Int in start ..n) {
            if (sum + i <= 10) {
                val list = ArrayList<Int>(selectedNum)
                list.add(i)
                backtrack(sum + i, list, i + 1, n)
            }
        }
    }

}