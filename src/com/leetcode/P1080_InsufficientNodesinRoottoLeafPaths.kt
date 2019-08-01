package com.leetcode

import kotlin.math.max


fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {

    val ans = dfs(root, limit, 0)

    return if (ans < limit) null else root
}

private fun dfs(root: TreeNode?, limit: Int, current: Int): Int {
    if (root == null) return Int.MIN_VALUE

    val left = dfs(root.left, limit, current + root.`val`)
    val right = dfs(root.right, limit, current + root.`val`)

    if (left < limit) root.left = null
    if (right < limit) root.right = null

    return if (max(left, right) == Int.MIN_VALUE) current + root.`val` else max(left, right)
}