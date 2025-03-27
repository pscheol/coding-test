class NQueen {
    lateinit var width: BooleanArray
    lateinit var diagonal1: BooleanArray
    lateinit var diagonal2: BooleanArray
    var N: Int = 0
    fun solution(n: Int): Int {
        this.N = n
        this.width = BooleanArray(n)
        this.diagonal1 = BooleanArray(n * 2)
        this.diagonal2 = BooleanArray(n * 2)
        var answer = solve(0)
        return answer
    }
    private fun solve(y: Int): Int {
        var ans = 0

        if (y == N) {
            ans++
        } else {
            for (i: Int in 0 until N) {
                println("start width = ${width.contentToString()}")
                println("start diagonal1 = ${diagonal1.contentToString()}, \n      diagonal2 = ${diagonal2.contentToString()}")
                if (width[i] || diagonal1[i + y] || diagonal2[i - y + N]) {
                    continue
                }
                width[i] =  true
                diagonal1[i + y] = true
                diagonal2[i - y + N] = true

                ans += solve(y + 1)

                width[i] = false
                diagonal1[i + y] = false
                diagonal2[i - y + N] = false
                println("end width = ${width.contentToString()}")
                println("end diagonal1 = ${diagonal1.contentToString()}, \n    diagonal2 = ${diagonal2.contentToString()}")
            }
        }
        return ans
    }
}