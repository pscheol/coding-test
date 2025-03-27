import java.util.ArrayDeque

class Miro {
    private val move = arrayOf(
        intArrayOf(0 ,-1),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(1 ,0),
    )
    fun solution(maps: Array<String>): Int {

        val n = maps.size
        val m = maps[0].length
        val map = Array(n) { maps[it].toCharArray().copyOf() }

        var start: Point? = null;
        var end: Point? = null;
        var lever: Point? = null;

        //시작지점, 종료지점, 레버 위치 탐색
        map.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, ch ->
                if (ch == 'S') {
                    start = Point(j, i)
                }
                if (ch == 'E') {
                    end = Point(j, i)
                }
                if (ch == 'L') {
                    lever = Point(j, i)
                }
            }
        }

        val startLever = bfs(start!!, lever!!, map, n, m)
        println()
        val leverEnd = bfs(lever!!, end!!, map, n, m)

        println("startLever=$startLever, leverEnd=$leverEnd")
        if (startLever == -1 || leverEnd == -1) {
            return -1
        } else {
            return startLever + leverEnd
        }
    }

    fun bfs(start: Point, end: Point, map: Array<CharArray>, n:Int, m: Int): Int {
        val dist = Array<IntArray>(n) { IntArray(n) { 0 } }
        val queue = ArrayDeque<Point>()
        dist[start.y][start.x] = 1
        queue.offer(start)

        while (queue.isNotEmpty()) {
            val v = queue.poll()

            for (i: Int in 0 until 4) {
                val nx = v.x + move[i][0]
                val ny = v.y + move[i][1]

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue
                }

                if (dist[ny][nx] > 0) {
                    continue
                }

                if (map[ny][nx] == 'X') {
                    continue
                }

                dist[ny][nx] = dist[v.y][v.x] + 1

                queue.offer(Point(nx, ny))

                if (nx == end.x && ny == end.y) {
                    for (ints in dist) {
                        println(ints.contentToString())
                    }

                    return dist[end.y][end.x] - 1
                }
            }
        }
        for (ints in dist) {
            println(ints.contentToString())
        }
        return -1
    }

    data class Point(
        val x: Int,
        val y: Int
    )
}