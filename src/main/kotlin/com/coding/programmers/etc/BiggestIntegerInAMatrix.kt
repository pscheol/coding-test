package com.coding.programmers.etc


fun main() {
    val solver = BiggestIntegerInAMatrix()

    val board1 = arrayOf(
        intArrayOf(9, 1, 1, 0, 7),
        intArrayOf(1, 0, 2, 1, 0),
        intArrayOf(1, 9, 1, 1, 0)
    )
    println(solver.solution(board1)) // 출력: 9121

    val board2 = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 3, 4),
        intArrayOf(1, 4, 3)
    )
    println(solver.solution(board2)) // 출력: 4343

    val board3 = arrayOf(
        intArrayOf(1, 2, 3, 4, 5)
    )
    println(solver.solution(board3)) // 출력: 5432
}

class BiggestIntegerInAMatrix {
    private val dr = intArrayOf(-1, 1, 0, 0)
    private val dc = intArrayOf(0, 0, -1, 1)
    private var max = 0
    private var n = 0
    private var m = 0

    fun solution(board: Array<IntArray>): Int {
        n = board.size
        m = board[0].size
        max = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                val path = mutableListOf(Pair(i, j))
                find(i, j, path, board, board[i][j].toString())
            }
        }
        return max
    }

    private fun isValid(row: Int, col: Int): Boolean {
        return row in 0 until n && col in 0 until m
    }

    private fun find(row: Int, col: Int, curPath: MutableList<Pair<Int, Int>>, board: Array<IntArray>, cur: String) {
        if (curPath.size == 4) {
            val num = cur.toInt()
            max = maxOf(max, num)
            return
        }

        for (i in 0..3) {
            val nextRow = row + dr[i]
            val nextCol = col + dc[i]
            val nextPos = Pair(nextRow, nextCol)

            if (isValid(nextRow, nextCol) && nextPos !in curPath) {
                curPath.add(nextPos)
                val next = cur + board[nextRow][nextCol].toString() // 문자열로 이어붙이기
                find(nextRow, nextCol, curPath, board, next)
                curPath.removeAt(curPath.size - 1) // 백트래킹
            }
        }
    }
}