class UnionFind {
    fun solution(k: Int, operations: Array<IntArray>): Array<Boolean> {
        val parent = IntArray(k)

        //초기화
        for (i in 0 until k) {
            parent[i] = i
        }

        val ans = ArrayList<Boolean>()
        for (op in operations) {
            if (op[0] == 0) {
                union(op[1], op[2], parent)
            }
            else {
                ans.add(find(op[1], parent) == find(op[2], parent))
            }
        }
        return ans.toTypedArray()
    }

    fun union(x: Int, y: Int, parent: IntArray) {
        val root1 = find(x, parent)
        val root2 = find(y, parent)
        parent[root2] = root1
    }
    fun find(x: Int, parent: IntArray): Int {
        if (parent[x] == x) { //자기자신일 경우(루트노드 라면 x 반환
            return x
        }
        parent[x] = find(parent[x], parent)

        return parent[x]
    }
}