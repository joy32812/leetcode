package com.leetcode

import java.util.*

class P1740_FindDistanceinaBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findDistance(root: TreeNode?, p: Int, q: Int): Int {
        var pathA = listOf<Int>();
        var pathB = listOf<Int>();

        fun dfs(cur: TreeNode?, path: LinkedList<Int>) {
            if (cur == null) return
            path.add(cur.`val`)

            if (cur.`val` == p) pathA = path.toList()
            if (cur.`val` == q) pathB = path.toList()

            dfs(cur.left, path)
            dfs(cur.right, path)
            path.removeLast()
        }

        dfs(root, LinkedList())

        var i = 0
        while (i < pathA.size && i < pathB.size && pathA[i] == pathB[i]) i++

        return pathA.size + pathB.size - 2 * i
    }

}


