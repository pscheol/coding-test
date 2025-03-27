import java.util.*
import kotlin.collections.ArrayList

class Dijkstra {
    fun solution(graph: Array<IntArray>, start:Int, n: Int): IntArray {
        val adjList = Array<ArrayList<Node>>(n + 1) { ArrayList<Node>() }
        for (edge in graph) {
            adjList[edge[0]].add(Node(edge[1], edge[2]))
        }

        return dijkstra(adjList, start, n)
    }

    fun dijkstra(adjList: Array<ArrayList<Node>>, start:Int, n: Int): IntArray {
        val queue = PriorityQueue<Node>()
        val dist = IntArray(n) { Int.MAX_VALUE}
        val visited = mutableSetOf<Int>()
        queue.offer(Node(start, 0))
        dist[start] = 0

        while (queue.isNotEmpty()) {
            val v = queue.poll()
            if (dist[v.edge] < v.weight) {
                continue
            }

            if (visited.contains(v.edge)) {
                continue
            }

            visited.add(v.edge)

            for (next in adjList[v.edge]) {
                if (dist[next.edge] > v.weight + next.weight) { //더짧은 거리를 발견
                    dist[next.edge] = v.weight + next.weight
                    queue.offer(Node(next.edge, dist[next.edge]))
                }
            }
        }
        return dist
    }

    data class Node(
        val edge: Int = 0,
        val weight: Int = 0
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return weight.compareTo(other.weight)
        }
    }
}