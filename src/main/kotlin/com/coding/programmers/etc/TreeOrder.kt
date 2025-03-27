class TreeOrder {

    fun solution(nodes: Array<IntArray>): Array<String> {
        val result = mutableListOf<String>()
        result[0] = preorder(nodes, 0).trim()
        result[1] = inorder(nodes, 0).trim()
        result[2] = postorder(nodes, 0).trim()
        return result.toTypedArray()
    }

    /**
     * left - root - right
     */
    fun inorder(nodes: Array<IntArray>, cur: Int): String {
        if (cur >= nodes.size) {
            return ""
        }
        return "${preorder(nodes, cur + 1)} ${nodes[cur]} ${preorder(nodes, cur + 2)}"
    }


    /**
     * root - left -right
     */
    fun preorder(nodes: Array<IntArray>, cur: Int): String {
        if (cur >= nodes.size) {
            return ""
        }

        return "${nodes[cur]} ${preorder(nodes, cur + 1)} ${preorder(nodes, cur + 2)}"
    }

    /**
     * left - right - root
     */
    fun postorder(nodes: Array<IntArray>, cur: Int): String {
        if (cur >= nodes.size) {
            return ""
        }
        return "${postorder(nodes, cur + 1)} ${postorder(nodes, cur + 2)} ${nodes[cur]} "
    }

}