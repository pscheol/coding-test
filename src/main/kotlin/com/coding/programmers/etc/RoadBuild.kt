import java.util.ArrayDeque

class RoadBuild {
    private val move: Array<IntArray> = arrayOf(
        intArrayOf(0,-1),
        intArrayOf(-1,0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
    )

    fun solution(board: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE
        val n = board.size

        val visited: Array<Array<IntArray>> = Array(n) { Array(n) { IntArray(4)} }
        val queue = ArrayDeque<Node>()

        queue.add(Node(0, 0, -1, 0))

        while (queue.isNotEmpty()) {
            val now = queue.poll()
            for (i: Int in 0 until 4) {
                val nx = now.x + move[i][0]
                val ny = now.y + move[i][1]

                if (isBlocked(board, nx, ny, n)) {
                    continue
                }

                val newCost = now.calculateCost(i)

                if (nx == n - 1 && ny == n - 1) {
                    println("answer=$answer , newCost=$newCost")
                    answer = answer.coerceAtMost(newCost)
                } else if (isShouldUpdate(nx, ny, i ,newCost, visited)) {
                    queue.add(Node(nx, ny, i, newCost))
                    visited[ny][nx][i] = newCost
                }
            }
        }


        for (intArrays in visited) {
            for (intArray in intArrays) {
                println(intArray.contentToString())
            }
        }

        return answer
    }
    private fun isNotValid(x: Int, y: Int, n: Int): Boolean {
        return !((x in 0 until n) && (y in 0 until n))
    }

    private fun isBlocked(board: Array<IntArray>, x: Int, y: Int, n: Int): Boolean {
        return (x == 0 && y == 0) || isNotValid(x, y, n) || board[y][x] == 1
    }
    private fun isShouldUpdate(x: Int, y: Int, direction: Int, newCost: Int, visited: Array<Array<IntArray>>): Boolean {
        return visited[y][x][direction] == 0 || visited[y][x][direction] > newCost
    }


    data class Node(
        val x: Int,
        val y: Int,
        val direction: Int,
        val cost: Int,
    ) {

        fun calculateCost(newDirection: Int): Int {
            return if (direction == -1 || ((direction - newDirection) % 2 == 0)) {
                cost + 100 //직선
            } else {
                cost + 600 //직선 + 코너
            }
        }
    }
}