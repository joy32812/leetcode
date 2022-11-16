/**
 * 1. get the height of each node
 * 2. find out other max height for each node.
 */
fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {

    val nodeHeights = mutableMapOf<TreeNode, Int>()

    fun dfsHeight(node: TreeNode?): Int {
        if (node == null) return 0
        val h = 1 + maxOf(dfsHeight(node.left), dfsHeight(node.right))
        nodeHeights[node] = h
        return h
    }
    dfsHeight(root)


    val ansMap = mutableMapOf<Int, Int>()

    fun work(node: TreeNode?, otherMax: Int = 0, parentHeight: Int = 0) {
        if (node == null) return
        ansMap[node.`val`] = otherMax

        work(node.left, maxOf(otherMax, (nodeHeights[node.right] ?: 0) + parentHeight), parentHeight + 1)
        work(node.right, maxOf(otherMax, (nodeHeights[node.left] ?: 0) + parentHeight), parentHeight + 1)
    }

    work(root)

    return queries.map { ansMap[it]!! }.toIntArray()
}
