import java.util.*


class 큰수만들기 {
    fun solution(number: String, k: Int): String {
        val len: Int = number.length
        val answer = Stack<Char>()
        var kk = k
        for (i in 0 until len) {
            val cur: Char = number[i]
            while (!answer.isEmpty() && answer.peek() < cur && kk-- > 0) {
                answer.pop()
            }
            answer.push(cur)
        }

        val result = StringBuilder()
        while (!answer.isEmpty()) {
            result.append(answer.pop())
        }

        if (kk > 0) {
            return result.reverse().toString().substring(0, result.toString().length - kk)
        }

        return result.reverse().toString()
    }
}
/**
 * 입력값 〉 "190000002", 3
 * 기댓값 〉 "900002"
 */