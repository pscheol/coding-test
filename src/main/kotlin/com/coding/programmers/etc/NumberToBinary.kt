import java.util.Stack

class NumberToBinary {

    fun solution(decimal: Int): String {
        val stack = Stack<Int>()
        var number = decimal
        while (number > 0) {
            val reminder = number % 10
            stack.push(reminder)
            number /= 2
        }

        val sb = StringBuilder()
        while(stack.isNotEmpty()) {
            sb.append(stack.pop())
        }

        return sb.toString()
    }
}