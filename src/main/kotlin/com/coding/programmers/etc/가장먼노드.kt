import java.util.*

class 가장먼노드 {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val adjList = Array<ArrayList<Int>>(n + 1) { ArrayList() }

        for (e in edge) {
            adjList[e[0]].add(e[1])
            adjList[e[1]].add(e[0])
        }
        return bfs(1,  n, adjList)
    }
    fun bfs(start: Int, n: Int, adjList: Array<ArrayList<Int>>): Int {
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(n + 1)
        val dist = IntArray(n + 1)
        var max = 0

        queue.add(start)
        visited[start] = true

        while ( queue.isNotEmpty() ) {
            val now = queue.poll()

            for (v in adjList[now]) {
                if (!visited[v]) {
                    dist[v] = dist[now] + 1
                    visited[v] = true
                    queue.add(v)
                    max = max.coerceAtLeast(dist[v])
                }
            }
        }

        println(dist.contentToString())
        return dist.count { it == max }
    }

//  /*  fun solution(n: Int, edge: Array<IntArray>): Int {
//        val adjList = Array<ArrayList<Node>>(n + 1) { ArrayList() }
//
//        for (e in edge) {
//            val n1 = Node(e[1])
//            val n2 = Node(e[0])
//            n1.add(n2)
//            n2.add(n1)
////            adjList[e[0]].add(n1)
////            adjList[e[1]].add(n2)
//        }
//
//        for (nodes in adjList) {
//            println(nodes)
//        }
//        return bfs(n, adjList)
//    }
//    fun bfs(n: Int, adjList: Array<ArrayList<Node>>): Int {
//        val queue = ArrayDeque<Node>()
//        var result = 0
//
//        queue.add(Node(1, 0, true, adjList[1]))
//
//        while ( queue.isNotEmpty() ) {
//            val now = queue.poll()
//
//            for (next in now.edge) {
//                if (!next.visited) {
//                    queue.add(Node(next.num, now.distance + 1, true, next.edge))
//                    result = result.coerceAtLeast(next.distance)
//                }
//            }
//        }
//
//        return result
//    }
//    data class Node(
//        val num: Int,
//        val distance: Int = 0,
//        val visited: Boolean = false,
//        val edge: MutableList<Node> = mutableListOf(),
//
//    ) {
//        fun add(node: Node) {
//            edge.add(node)
//        }
//    }
//*/
}