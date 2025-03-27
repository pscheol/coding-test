class 나선형배치 {
    fun solution(n: Int): Array<IntArray> {
        val answer = Array(n) { IntArray(n) }

        var x = 0
        var y = 0
        var dir = 0
        val dy = intArrayOf(0, 1, 0 , -1)
        val dx = intArrayOf(1, 0, -1 , 0)

        for (num in 1.. n * n) {
            answer[y][x] = num
            println("y=$y, x=$x, dir=$dir")
            for (a in answer) {
                println(a.contentToString())
            }
            var ny = y + dy[dir]
            var nx = x + dx[dir]
            println("ny=$ny, nx=$nx")
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || answer[ny][nx] != 0) {
                dir = (dir + 1) % 4
                ny = y + dy[dir]
                nx = x + dx[dir]
            }
            y = ny
            x = nx
        }

        return answer
    }
}