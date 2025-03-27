class FindRoad {
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val node: Node = makeNode(nodeinfo)
        val preorder: ArrayList<Int> = arrayListOf()
        val postorder: ArrayList<Int> = arrayListOf()
        preorder(node, preorder)
        postorder(node, postorder)

        return arrayOf(preorder.toIntArray(), postorder.toIntArray())
    }

    //root - left - right
    fun preorder(cur: Node?, ans: ArrayList<Int>) {
        if (cur == null) {
            return
        }
        ans.add(cur.num)
        preorder(cur.left, ans)
        preorder(cur.right, ans)
    }
    fun postorder(cur: Node?, ans: ArrayList<Int>) {
        if (cur == null) {
            return
        }
        postorder(cur.left, ans)
        postorder(cur.right, ans)
        ans.add(cur.num)
    }

    private fun makeNode(nodeinfo: Array<IntArray>): Node {
        val nodes: Array<Node> = nodeinfo.mapIndexed { index, (x, y) ->
            Node(index + 1, x, y)
        }.sortedWith(compareByDescending<Node> { it.y }.thenBy { it.x }).toTypedArray()

        val root = nodes.first()

        nodes.drop(1).forEach { node ->
            var parent = root

            while (true) {
                if (node.x < parent.x) {
                    if (parent.left == null) {
                        parent.left = node
                        break
                    } else {
                        parent = parent.left!!
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = node
                        break
                    } else {
                        parent = parent.right!!
                    }
                }
            }
        }
        return root
    }

    data class Node(
        val num: Int,
        val x: Int,
        val y: Int,
        var left: Node? = null,
        var right: Node? = null,
    )
}