import java.util.*

class DFS {
    fun solution(graph: Array<IntArray>, start: Int, n: Int): Array<Int> {
        val adjList = Array<ArrayList<Int>>(n + 1) { ArrayList() }
        val visited = BooleanArray(n + 1)
        val ans = mutableListOf<Int>()
        for (edge in graph) {
            adjList[edge[0]].add(edge[1])
        }

        dfs(start, adjList, visited, ans)
        println(dfsStack(start, adjList).contentToString())
        return ans.toTypedArray()
    }

    private fun dfsStack(now: Int, adjList: Array<ArrayList<Int>>): Array<Int> {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        val ans = mutableListOf<Int>()
        stack.push(now)
        visited.add(now)

        for (edge in adjList) {
            edge.sortDescending()
        }

        while (stack.isNotEmpty()) {
            val v = stack.pop()

            ans.add(v)

            for (next in adjList[v]) {
                println("v=$v next=$next")
                if (!visited.contains(next)) {
                    visited.add(next)
                    stack.push(next)
                }
            }
        }
        return ans.toTypedArray()
    }
    private fun dfs(now: Int, adjList: Array<ArrayList<Int>>, visited: BooleanArray, ans: MutableList<Int>) {
        visited[now] = true
        ans.add(now)

        for (next in adjList[now]) {
            if (!visited[next]) {
                dfs(next, adjList, visited, ans)
            }
        }
    }

}