import java.util.ArrayDeque

class GameMap {
    val move = arrayOf(
        intArrayOf(0, 1), // up
        intArrayOf(0, -1), // down
        intArrayOf(1, 0), // left
        intArrayOf(-1, 0), //right
    )

    fun solution(maps: Array<IntArray>): Int {
        val N = maps.size
        val M = maps[0].size

        val dist = Array(N) { IntArray(M) }

        val queue = ArrayDeque<Node>()

        queue.offer(Node(0, 0))
        dist[0][0] = 1

        while (queue.isNotEmpty()) {
            val v = queue.poll()
            for (i: Int in 0 until 4) {
                val nr = v.r + move[i][0]
                val nc = v.c + move[i][1]

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) { //범위 벗어날 경우
                    continue
                }

                if (maps[nr][nc] == 0) { //벽
                    continue
                }

                if (dist[nr][nc] == 0) {
                    queue.offer(Node(nr, nc))
                    dist[nr][nc] = dist[v.r][v.c] + 1
                }
            }
        }
        for (ints in dist) {
            println(ints.contentToString())
        }


        return if (dist[N - 1][M - 1] == 0) -1 else dist[N - 1][M - 1]
    }

    data class Node(
        val r: Int,
        val c: Int,
    )
}