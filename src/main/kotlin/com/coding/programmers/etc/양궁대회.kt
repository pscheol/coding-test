class 양궁대회 {
    private var max = 0
    private var answer = IntArray(11)
    private lateinit var apeach: IntArray

    fun start() {
        val result: IntArray = solution(5, intArrayOf(2,1,1,1,0,0,0,0,0,0,0))
        println(result.contentToString())
    }

    fun solution(n: Int, info: IntArray): IntArray {
        this.apeach = info.copyOf()

        calculate(n, 0, IntArray(11))

        return if (max == 0) intArrayOf(-1) else answer
    }

    private fun calculate(arrow: Int, start: Int, ryan: IntArray) {
        if (arrow == 0) {
            //화살 다쓸경우
            calculateDiff(ryan)
            return
        }

        for (i in start .. 10) {
            val cnt = arrow.coerceAtMost(apeach[i] + 1)
            ryan[i] = cnt
            calculate(arrow - cnt, i + 1, ryan)
            ryan[i] = 0
        }
    }

    private fun calculateDiff(ryan: IntArray) {
        val score = getSource(ryan)
        if (max < score) {
            max = score
            answer = ryan.copyOf()
        } else if (max > 0 && max == score) {
            for (i: Int in 10 downTo 0) {
                if (answer[i] != ryan[i]) {
                    if (answer[i] < ryan[i]) {
                        answer = ryan.copyOf()
                    }
                    break;
                }
            }
        }
    }

    private fun getSource(ryan: IntArray): Int {
        var score = 0

        for (i: Int in 0..10) {
            if (ryan[i] + apeach[i] > 0)
                score += if (ryan[i] > apeach[i]) (10 - i) else -(10 - i)
        }
        return score
    }
}