package com.coding.programmers.graph.bfs

import java.util.LinkedList
import java.util.Queue

fun main() {
    val result = 퍼즐조각채우기().solution(
        arrayOf(
            intArrayOf(1,1,0,0,1,0),
            intArrayOf(0,0,1,0,1,0),
            intArrayOf(0,1,1,0,0,1),
            intArrayOf(1,1,0,1,1,1),
            intArrayOf(1,0,0,0,1,0),
            intArrayOf(0,1,1,1,0,0)
        ),
        arrayOf(
            intArrayOf(1,0,0,1,1,0),
            intArrayOf(1,0,1,0,1,0),
            intArrayOf(0,1,1,0,1,1),
            intArrayOf(0,0,1,0,0,0),
            intArrayOf(1,1,0,1,1,0),
            intArrayOf(0,1,0,0,0,0)
        ),
    )
    println(result)
}

class 퍼즐조각채우기 {
    private val dx = intArrayOf(-1, 1, 0, 0) //left, right, top, down
    private val dy = intArrayOf(0, 0, 1, -1) //left, right, top, down

    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        val n = game_board.size
        val emptySpaces = extractBlocks(game_board, 0)
        val puzzleBlocks = extractBlocks(table, 1)
        val used = BooleanArray(puzzleBlocks.size)
        var answer: Int = 0

        println("emptySpaces = $emptySpaces")
        println("puzzleBlocks = $puzzleBlocks")

        for (space in emptySpaces) {
            println("space = $space")
            for ((i, puzzle) in puzzleBlocks.withIndex()) {
                println("puzzle = $puzzle")
                if (used[i]) continue
                for (rotated in rotateAll(puzzle)) {
                    if (space == rotated) {
                        used[i] = true
                        answer += space.size
                        break
                    }
                }
                if (used[i]) break
            }
        }
        return answer
    }

    private fun extractBlocks(board: Array<IntArray>, target: Int) : MutableList<List<Pair<Int, Int>>> {
        val n = board.size
        val visited = Array(n) { BooleanArray(n) }
        val result = mutableListOf<List<Pair<Int, Int>>>()

        fun bfs(sx: Int, sy: Int): List<Pair<Int, Int>> {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(Pair(sx, sy))
            visited[sx][sy] = true
            val block = mutableListOf<Pair<Int, Int>>()

            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                block.add(Pair(x, y))

                for (dir in 0 until 4) {
                    val nx = x + dx[dir]
                    val ny = y + dy[dir]

                    if (nx in 0 until n && ny in 0 until n
                        && !visited[nx][ny] && board[nx][ny] == target
                    ) {
                        visited[nx][ny] = true
                        queue.add(Pair(nx, ny))
                    }
                }
            }


//            println("block= $block")
            //기준 좌표 정렬
            return sortedByRotatedMap(block)
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j] && board[i][j] == target) {
                    result.add(bfs(i, j))
                }
            }
        }

//        println("result= $result")
        return result
    }

    private fun rotate(block: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val rotated = block.map { Pair(it.second, -it.first) } //90도 회전
        return sortedByRotatedMap(rotated)
    }

    private fun sortedByRotatedMap(rotated: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val minX = rotated.minOf { it.first }
        val minY = rotated.minOf { it.second }
        return rotated.map { Pair(it.first - minX, it.second - minY) }
            .sortedWith(compareBy({ it.first }, { it.second }))
    }

    private fun rotateAll(block: List<Pair<Int, Int>>): List<List<Pair<Int, Int>>> {
        val rotations = mutableListOf<List<Pair<Int, Int>>>()
        var current = block
        repeat(4) {
            current = rotate(current)
            rotations.add(current)
        }
        println("rotations = $rotations")
        return rotations
    }
}