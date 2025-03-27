class 방문길이 {
    private val LOCATION: Map<Char, Array<Int>> = mapOf(
        'U' to arrayOf(0, 1),
        'D' to arrayOf(-1, 0),
        'R' to arrayOf(1, 0),
        'L' to arrayOf(-1, 0),
    )

    fun solution(dirs: String): Int {
        var x = 5
        var y = 5

        val answer: MutableSet<String> = mutableSetOf()

        for (dir in dirs) {
            val offset: Array<Int> = LOCATION[dir]!!
            val nx = x + offset[0]
            val ny = y + offset[1]
            println("$dir $nx $ny")
            //범위 초과 여부 확인
            if (isInValidMove(nx, ny)) {
                continue
            }
            answer.add("$nx $ny <> $x, $y")
            answer.add("$x $y <> $nx, $ny")
            x = nx
            y = ny
        }
        return answer.size / 2
    }

    private fun isInValidMove(nx: Int, ny: Int): Boolean {
        return !((nx in 0..10) && (ny in 0..10))
    }
}