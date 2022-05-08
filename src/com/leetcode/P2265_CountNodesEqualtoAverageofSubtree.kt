package com.leetcode

/**
 * Tree DP
 */
fun averageOfSubtree(root: TreeNode?): Int {
    var ans = 0

    fun getSum(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return 0 to 0

        val left = getSum(root.left)
        val right = getSum(root.right)

        val sum = left.first + right.first + root.`val`
        val cnt = left.second + right.second + 1

        if (sum / cnt == root.`val`) ans++

        return sum to cnt
    }

    getSum(root)

    return ans
}
