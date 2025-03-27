import java.util.Stack

/**
 * 바구니가 빈 경우
 * 무조건 푸시
 * 바구니가 비어있지 않은 경우
 *  바구니에 있는 Top과 꺼낸 데이터와 같은지 비교
 *      같다면 Top에 있는 인형을 사라지고 카운트
*       같지 않다면 푸시
 */
class CrainDoolGame {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        val bucket = Stack<Int>()
        val stack: Array<Stack<Int>> = initStackArr(board)

        for (move in moves) {
            if (stack[move - 1].isEmpty()) {
                continue
            }
            val pop: Int = stack[move-1].pop()
            if (bucket.isNotEmpty() && bucket.peek() == pop) {
                bucket.pop()
                answer+=2
            } else {
                bucket.push(pop)
            }
        }

        return answer
    }

    private fun initStackArr(board: Array<IntArray>): Array<Stack<Int>> {
        val stacks = Array<Stack<Int>>(board.size, { Stack() })
        for (i: Int in board.size - 1 downTo 0) {
            for (j: Int in 0 until board[i].size) {
                if (board[i][j] != 0) {
                    stacks[j].push(board[i][j])
                }
            }
        }
        return stacks;
    }
}