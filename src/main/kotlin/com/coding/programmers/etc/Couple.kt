import java.util.Stack

class Couple {
    fun solution(s: String): Int {

        val stack: Stack<Char> = Stack()
        for (c in s.toCharArray()) {
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        return if (stack.isEmpty()) 1 else 0
    }
}