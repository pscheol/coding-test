import java.util.PriorityQueue

class Delivery {
    fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
        val adjList = Array<ArrayList<Node>>(n + 1) { ArrayList() }
        for (edge in road) {
            adjList[edge[0]].add(Node(edge[1], edge[2]))
            adjList[edge[1]].add(Node(edge[0], edge[2]))
        }

        val queue = PriorityQueue<Node>()
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        queue.offer(Node(1, 0))
        dist[1] = 0

        while (queue.isNotEmpty()) {
            val now = queue.poll()

            if (dist[now.dest] < now.cost)
                continue

            for (next in adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost
                    queue.add(Node(next.dest, dist[next.dest]))
                }
            }
        }

        println("test = ${dist.contentToString()}")
        var ans = 0
        for (i:Int in 1 ..  n) {
            if (dist[i] <= k) ans++
        }
        return ans
    }

    data class Node(
        val dest: Int,
        val cost: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return cost.compareTo(other.cost)
        }
    }

}