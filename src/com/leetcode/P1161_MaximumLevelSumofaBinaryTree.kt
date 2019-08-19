package com.leetcode


fun maxLevelSum(root: TreeNode?): Int {

    val map = mutableMapOf<Int, Int>()

    fun dfs(root: TreeNode?, d: Int) {
        if (root == null) return
        map[d] = (map[d] ?: 0) + root.`val`

        dfs(root.left, d + 1)
        dfs(root.right, d + 1)
    }

    dfs(root, 1)

    val max = map.values.max()!!
    return map.filter { it.value == max }.keys.min()!!

}


fun main() {

}