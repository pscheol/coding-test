import java.util.Stack

class ReplaceG {
    val check: Map<Char, Char> = mapOf('(' to ')', '{' to '}', '[' to ']')

    fun solution(s: String): Int {
        var ans: Int = 0
        val chars: CharArray = s.toCharArray()

        for (i:Int in chars.indices) {
            val stack: Stack<Char> = Stack<Char>()
            for (j: Int in chars.indices) {
               val ch = chars[(i + j) % chars.size]
                if (check.containsKey(ch)) {
                    stack.push(ch)
                } else if (stack.isEmpty() || check[stack.pop()] != ch) {
                    stack.push(ch)
                    break;
                }
            }

            if (stack.isEmpty()) {
                ans++
            }
        }
        return ans
    }
}