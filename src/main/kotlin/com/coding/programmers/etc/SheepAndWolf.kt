import java.util.*

class SheepAndWolf {
    private val SHEEP = 0
    private val WOLF = 1
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        val adjList: Array<ArrayList<Int>> = initTree(info, edges)
        var answer: Int = 0


        //dfs
        val queue: Queue<Info> = ArrayDeque()
        queue.add(Info(0, 1,0, HashSet()))

        while (queue.isNotEmpty()) {
            val now = queue.poll()

            answer = answer.coerceAtLeast(now.sheep);
            // 방문 노드 추가
            now.visited.addAll(adjList[now.node])

            //인접노드 탐색
            for (next: Int in now.visited) {
                val visit = HashSet(now.visited)
                //현재 방문한 정범 제거
                visit.remove(next)

                if (info[next] == WOLF) { //wolf
                    if (now.sheep != now.wolf + 1) {
                        queue.offer(Info(next, now.sheep, now.wolf + 1, visit))
                    }
                } else {
                    queue.offer(Info(next, now.sheep + 1, now.wolf, visit))
                }
            }
        }

        return answer
    }

    private fun initTree(info: IntArray, edges: Array<IntArray>): Array<ArrayList<Int>> {
        val adjList: Array<ArrayList<Int>> = Array(info.size) { ArrayList() }

        for (edge in edges) {
            adjList[edge[0]].add(edge[1])
        }
        return adjList
    }

    data class Info(
        val node: Int,
        val sheep: Int,
        val wolf: Int,
        val visited: HashSet<Int>
    )
}