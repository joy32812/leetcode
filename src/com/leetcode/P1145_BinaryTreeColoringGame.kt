package com.leetcode


fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {

    var ans:Pair<Int, Int> = Pair(0, 0)
    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val left = dfs(root.left)
        val right = dfs(root.right)

        if (root.`val` == x) ans = Pair(left, right)
        return left + right + 1
    }

    dfs(root)

    val (left, right) = ans
    return Math.max(Math.max(left, right), n - left - right - 1) > n / 2
}