package com.leetcode

import java.util.*

/**
 * buildTree
 * traverse Tree
 * Check subtree equal
 */
fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {

    class TreeNode(val name: String, val children: TreeMap<String, TreeNode>, var mask: String = "")
    val root = TreeNode("/", TreeMap())
    val maskMap = mutableMapOf<String, Int>()

    fun buildTree() {
        for (path in paths) {
            var tmp = root
            for (p in path) {
                if (p !in tmp.children) tmp.children[p] = TreeNode(p, TreeMap())
                tmp = tmp.children[p]!!
            }
        }
    }

    fun dfs(root: TreeNode): String {
        val childrenStr = root.children.values.map { dfs(it) }.joinToString("|")
        root.mask = childrenStr
        maskMap[root.mask] = (maskMap[root.mask] ?: 0) + 1
        return "(" + childrenStr + ")" + root.name
    }

    val ans = mutableListOf<List<String>>()
    fun traversal(root: TreeNode, cur: LinkedList<String>) {
        if (root.mask.isNotEmpty() && maskMap[root.mask]!! > 1) {
            return
        }

        ans += cur.toList()
        for (child in root.children.values) {
            cur.addLast(child.name)
            traversal(child, cur)
            cur.removeLast()
        }
    }

    buildTree()
    dfs(root)

    for (child in root.children.values) {
        val list = LinkedList<String>()
        list += child.name
        traversal(child, list)
    }

    return ans
}

fun main() {
    deleteDuplicateFolder(
        listOf(
            listOf("a"),
            listOf("c"),
            listOf("d"),
            listOf("a", "b"),
            listOf("c", "b"),
            listOf("d", "a")
        )
    )


}
