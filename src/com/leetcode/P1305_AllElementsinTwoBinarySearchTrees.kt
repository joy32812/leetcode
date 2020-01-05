package com.leetcode


fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {

    val nums = mutableListOf<Int>()
    fun inOrder(r: TreeNode?) {
        if (r == null) return
        inOrder(r.left)
        nums += r.`val`
        inOrder(r.right)
    }

    inOrder(root1)
    inOrder(root2)
    nums.sort()

    return nums
}
