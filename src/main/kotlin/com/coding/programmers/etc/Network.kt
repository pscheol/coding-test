class Network {

    fun dfs(now: Int, computer: Array<IntArray>, visited: BooleanArray) {
        visited[now] = true
        for (next in computer[now]) {
            if (next == 1 && !visited[now]) {
                dfs(next, computer, visited)
            }
        }
    }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n)
        val computer = computers.copyOf()
        var answer = 0
        for (i: Int in 0 until n) {
            if (!visited[i]) {
                dfs(i, computer, visited)
                answer = answer.plus(1)
            }
        }
        return answer
    }
}