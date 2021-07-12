package com.leetcode

/**
 * build tree.
 */
fun canMerge(trees: List<TreeNode?>): TreeNode? {

    val rootMap = mutableMapOf<Int, TreeNode>()
    val leafMap = mutableMapOf<Int, TreeNode>()
    val singleMap = mutableMapOf<Int, TreeNode>()

    val all = mutableSetOf<Int>()

    fun addLeaf(t: TreeNode): Boolean {
        if (t.`val` in leafMap) return false
        leafMap[t.`val`] = t

        all += t.`val`

        return true
    }


    for (t in trees) {
        if (t == null) continue

        all += t.`val`

        if (t.left == null && t.right == null) {
            singleMap[t.`val`] = t
            continue
        }

        if (t.`val` in rootMap) return null
        rootMap[t.`val`] = t

        if (t.left != null && !addLeaf(t.left)) return null
        if (t.right != null && !addLeaf(t.right)) return null
    }

    // check single map
    if (leafMap.isEmpty()) {
        return if (singleMap.size == 1) singleMap.entries.first().value else null
    }

    for (tval in singleMap.keys) {
        if (tval !in leafMap) return null
    }



    var rootVal = -1
    for (r in rootMap.keys) {
        if (r !in leafMap) {
            if (rootVal != -1) return null
            rootVal = r
        }
    }
    if (rootVal == -1) return null


    val allNodes = mutableSetOf<Int>()
    fun buildTree(value: Int, lower: Int, upper: Int): TreeNode? {
        allNodes += value

        if (value !in lower..upper) return null
        val res = TreeNode(value)
        if (value !in rootMap) return res

        val t = rootMap[value]!!

        if (t.left != null) {
            val left = buildTree(t.left.`val`, lower, value - 1) ?: return null
            res.left = left
        }

        if (t.right != null) {
            val right = buildTree(t.right.`val`, value + 1, upper) ?: return null
            res.right = right
        }

        return res
    }

    val ans = buildTree(rootVal, Int.MIN_VALUE, Int.MAX_VALUE)
    if (allNodes.size != all.size) return null

    return ans
}

fun main() {

    val t1 = TreeNode(2)
    val t2 = TreeNode(1)
    val t3 = TreeNode(3)

    t1.left = t2
    t1.right = t3

    canMerge(listOf(
        t1
    ))

}
