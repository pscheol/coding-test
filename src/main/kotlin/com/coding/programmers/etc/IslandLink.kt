import java.util.*

class IslandLink {

    fun solution(n: Int, costs: Array<IntArray>): Int {
        Arrays.sort(costs, { o1, o2 -> o1[2].compareTo(o2[2]) })
        val parent: IntArray = IntArray(n) { it }
        var answer = 0
        var edges = 0

        for (edge in costs) {
            if (edges == n - 1) {
                break;
            }
            if (find(edge[0], parent) != find(edge[1], parent)) {
                union(edge[0], edge[1], parent)
                answer += edge[2]
                edges++
            }
        }
        return answer
    }

    private fun find(x: Int, parent: IntArray) : Int {
        if (parent[x] == x) {
            return x
        }
        parent[x] = find(parent[x], parent)

        return parent[x]
    }

    private fun union(x: Int, y: Int, parent: IntArray) {
        val root1 = find(x, parent)
        val root2 = find(y, parent)
        parent[root2] = root1
    }
}