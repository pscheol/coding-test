import java.util.Stack

class 택배상자꺼내기 {
    fun start() {
        val result = solution(13, 3, 6)
        println(result)

        val result2 = solution(22, 6, 8)
        println(result2)
    }
    fun solution(n: Int, w: Int, num: Int): Int {
        val (desIndex, buckets) = init(w, n, num)
        var answer = 0

        val targetStack = buckets[desIndex]
        while (targetStack.isNotEmpty()) {
            answer++
            if (targetStack.pop() == num) break
        }

        return answer
    }


    private fun init(w: Int, n: Int, num: Int): Pair<Int, Array<Stack<Int>>> {
        val bucket = Array<Stack<Int>>(w) { Stack<Int>() }
        var idx = 0
        var desIndex = 0
        var turn = true


        for (i: Int in 1..n) {
            bucket[idx].push(i)
            if (i == num) desIndex = idx

            if (turn) {
                if (idx == w - 1) { turn = false } else { idx++ }
            } else {
                if (idx == 0) { turn = true } else { idx-- }
            }
        }
        return Pair(desIndex, bucket)
    }
}