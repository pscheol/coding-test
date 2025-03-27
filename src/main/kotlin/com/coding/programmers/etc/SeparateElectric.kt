import kotlin.math.abs

class SeparateElectric {
    var answer: Int = 0
    fun solution(n: Int, wires: Array<IntArray>): Int {
        val visited = BooleanArray(n + 1)
        val adjList = Array<ArrayList<Int>>(n + 1) { ArrayList() }
        this.answer = n - 1

        for (wire in wires) {
            adjList[wire[0]].add(wire[1])
            adjList[wire[1]].add(wire[0])
        }

        dfs(1, adjList, visited, n)


        return answer
    }

    private fun dfs(now: Int, adjList: Array<ArrayList<Int>>, visited: BooleanArray, n: Int): Int {
        visited[now] = true

        var sum = 0
        for (next in adjList[now]) {
            if (!visited[next]) {
                val count = dfs(next, adjList, visited, n)
                println("next=$next, count: $count, abs(n - count * 2)=${abs(n - count * 2)}")
                answer = answer.coerceAtMost(abs(n - count * 2))
                println("#dfs answer=$answer")
                sum += count
            }
        }
        return sum + 1
    }
}