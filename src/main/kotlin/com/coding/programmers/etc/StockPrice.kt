import java.util.*

class StockPrice {
    fun solution(prices: Array<Int>): Array<Int> {
        val n = prices.size
        val ans = Array(n) { 0 }
        val stack = Stack<Int>()

        for (i: Int in 0 until n) {
            if (stack.isNotEmpty() && prices[stack.peek()] > prices[i]) {
                val pop = stack.pop()
                ans[pop] = i - pop
            }
            stack.push(i)
        }

        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            ans[pop] = n -1 - pop;
        }
        return ans
    }
}