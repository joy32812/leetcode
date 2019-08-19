package com.leetcode


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private data class Result(val sum: Int, val num: Int)

var ans: Double = 0.0
fun maximumAverageSubtree(root: TreeNode?): Double {

    dfs(root)
    return ans
}

private fun dfs(root: TreeNode?): Result {
    if (root == null) return Result(0, 0)

    val left = dfs(root.left)
    val right = dfs(root.right)

    val sum = left.sum + right.sum + root.`val`
    val num = left.num + right.num + 1

    ans = Math.max(ans, 1.0 * sum / num)
    return Result(sum, num)
}
