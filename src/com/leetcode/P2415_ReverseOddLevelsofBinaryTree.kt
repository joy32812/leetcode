
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * 1. traverse
 * 2. reverse
 */
fun reverseOddLevels(root: TreeNode?): TreeNode? {

    val levelMap = mutableMapOf<Int, MutableList<Int>>()

    fun traverse(node: TreeNode?, level: Int) {
        if (node == null) return
        levelMap.getOrPut(level) { mutableListOf() } += node.`val`
        traverse(node.left, level + 1)
        traverse(node.right, level + 1)
    }

    traverse(root, 0)

    fun reverse(node: TreeNode?, level: Int) {
        if (node == null) return
        if (level % 2 == 1) {
            val last = levelMap[level]!!.size - 1
            node.`val` = levelMap[level]!!.removeAt(last)
        }
        reverse(node.left, level + 1)
        reverse(node.right, level + 1)
    }

    reverse(root, 0)
    return root
}
