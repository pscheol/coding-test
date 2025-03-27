import java.util.*

class Sudoku {
    data class Block(
        val i: Int,
        val j: Int,
    )

    lateinit var board: Array<IntArray>

    private fun isValid(num: Int, row: Int, col: Int): Boolean {
        return !(inRow(num, row) || inCol(num, col) || inBox(num, row, col))
    }

    private fun inRow(num: Int, row: Int): Boolean {
        return Arrays.stream(board[row]).anyMatch { it == num }
    }

    private fun inCol(num: Int, col: Int): Boolean {
        for (i: Int in 0 until 9) {
            if (board[i][col] == num) {
                return true
            }
        }
        return false
    }
    private fun inBox(num: Int, row: Int, col: Int): Boolean {
        val boxRow = (row / 3) * 3
        val boxCol = (col / 3) * 3

        for (i in boxRow until boxRow + 3) {
            for (j in boxCol until boxCol + 3) {
                if (board[i][j] == num) {
                    return true
                }
            }
        }
        return false
    }

    private fun findEmptyPosition() : Block? {
        for (i: Int in 0 until 9) {
            for (j: Int in 0 until 9) {
                if (board[i][j] == 0) {
                    return Block(i, j)
                }
            }
        }
        return null
    }

    private fun findSolution(): Boolean {
        val emptyBlock: Block = findEmptyPosition() ?: return true

        val row = emptyBlock.i
        val col = emptyBlock.j

        for (num: Int in 1 .. 9) {
            if (isValid(num, row, col)) {
                board[row][col] = num
                if (findSolution()) {
                    return true
                }

                board[row][col] = 0
            }
        }
        return false
    }

    fun solution(board: Array<IntArray>): Array<IntArray> {
        this.board = board.copyOf()
        findSolution()
        return board
    }
}