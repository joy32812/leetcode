import java.util.*

/**
 * TreeSet.
 */
fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {

    val treeSet = TreeSet<Int>()

    fun dfs(node: TreeNode?) {
        if (node == null) return
        treeSet.add(node.`val`)
        dfs(node.left)
        dfs(node.right)
    }

    dfs(root)

    fun work(x: Int): List<Int> {
        val a = treeSet.floor(x) ?: -1
        val b = treeSet.ceiling(x) ?: -1

        return listOf(a, b)
    }

    return queries.map { work(it) }
}
