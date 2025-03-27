package com.coding.programmers.graph.bfs

import java.util.ArrayDeque

fun main() {
    val sol = 게임맵최단거리()
    println(
        sol.solution(
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 1),
                intArrayOf(0, 0, 0, 0, 1)
            )
        )
    )


    println(
        sol.solution(
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1)
            )
        )
    )

    println(
        sol.solution(
            arrayOf(
                intArrayOf(1, 1)
            )
        )
    )
}
class 게임맵최단거리 {
    data class Node(val x: Int, val y: Int)

    val dx = intArrayOf(1, 0, -1 ,0)
    val dy = intArrayOf(0, 1, 0 ,-1)

    fun solution(maps: Array<IntArray>): Int {
        val n = maps.size
        val m = maps[0].size
        val dist = Array(n) { IntArray(m) }
        val queue = ArrayDeque<Node>()

        queue.offer(Node(0, 0))
        dist[0][0] = 1

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            for (i: Int in 0 until 4) {
                val nx = node.x + dx[i]
                val ny = node.y + dy[i]

                if (isOutOfIndex(nx, ny, n, m)) {
                    continue
                }

                if (maps[ny][nx] == 0) {
                    continue
                }

                if (dist[ny][nx] == 0) {

                    queue.offer(Node(nx, ny))
                    dist[ny][nx] = dist[node.y][node.x] + 1
                }
            }
        }

        return if (dist[n-1][m-1] == 0) -1 else dist[n-1][m-1]
    }
    fun isOutOfIndex(nx: Int, ny: Int, n: Int, m: Int): Boolean {
        return (nx < 0 || ny < 0 || ny >= n || nx >= m)
    }
}