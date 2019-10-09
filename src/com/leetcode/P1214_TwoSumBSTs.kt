package com.leetcode



fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    if (root1 == null || root2 == null) return false

    val sum = root1.`val` + root2.`val`
    if (sum == target) return true

    if (sum < target) return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target)
    return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target)
}
