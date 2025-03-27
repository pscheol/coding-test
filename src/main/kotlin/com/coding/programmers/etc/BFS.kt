import java.util.*

class BFS {
    fun solution(graph: Array<IntArray>, start: Int, n: Int): Array<Int> {
        val adjList = Array<ArrayList<Int>>(n + 1) { ArrayList() }
        for (edge in graph) {
            adjList[edge[0]].add(edge[1])
        }

        return bfs(start, adjList)
    }

    fun bfs(start: Int, adjList: Array<ArrayList<Int>>): Array<Int> {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        val answer = mutableListOf<Int>()
        queue.offer(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val vertex = queue.poll()

            answer.add(vertex)

            adjList[vertex].forEach {
                if (!visited.contains(it)) {
                    queue.offer(it)
                    visited.add(it)
                }
            }
        }

        return answer.toTypedArray()
    }
}