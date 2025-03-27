class OXQuiz {
    fun solution(quiz: Array<String>): Array<String> {
        val answer: Array<String> = Array(quiz.size) { "" }
        var cnt = 0
        for (q in quiz) {
            val split = q.split(" ")
            println(split)
            val x: Int = split[0].toInt()
            val y: Int = split[2].toInt()
            val z: Int = split[4].toInt()
            val op: String = split[1]

            if (isEquals(op, z, x, y)) {
                answer[cnt++] = "O"
            } else {
                answer[cnt++] = "X"
            }
        }
        return answer
    }

    private fun isEquals(op: String, z: Int, x: Int, y: Int): Boolean =
        if (op == "-") {
            z == x.minus(y)
        } else {
            z == x.plus(y)
        }

}