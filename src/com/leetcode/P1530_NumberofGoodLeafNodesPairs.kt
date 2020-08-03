package com.leetcode

var sum = 0
fun solve(root: TreeNode, distance: Int): Map<Int, Int> {
    if (root.left == null && root.right == null) {
        return mapOf(0 to 1)
    }

    if (root.left == null || root.right == null) {
        val childNode = if (root.left != null) root.left else root.right
        val child = solve(childNode, distance);
        val newMap = child.mapKeys { it.key + 1 }
        return newMap.filterKeys { it <= distance }
    }

    val left = solve(root.left, distance);
    val right = solve(root.right, distance);


    for (i in left.keys) {
        for (j in right.keys) {
            if (i + 1 + j + 1 > distance) continue
            sum += left[i]!! * right[j]!!;
        }
    }

    val newMap = mutableMapOf<Int, Int>()
    for (i in left.keys.union(right.keys)) {
        val ll = left[i] ?: 0
        val rr = right[i] ?: 0
        newMap.put(i + 1, ll + rr)
    }
    return newMap
}

fun countPairs(root: TreeNode?, distance: Int): Int {
    if (root == null) return 0
    sum = 0
    solve(root, distance)
    return sum
}

fun main() {
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)

    t1.left = t2
    t1.right = t3
    t2.right = t4

    println(countPairs(t1, 3))
}
