package com.leetcode

/**
 * nodeMap
 */
fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {

    val nodeMap = mutableMapOf<Int, TreeNode>()

    for ((p, c, isLeft) in descriptions) {
        val parent = nodeMap.getOrPut(p) { TreeNode(p) }
        val child = nodeMap.getOrPut(c) { TreeNode(c) }

        if (isLeft == 1) parent.left = child
        else parent.right = child
    }

    val children = descriptions.map { it[1] }.toSet()
    val parents = descriptions.map { it[0] }.toSet()

    val ints = parents subtract children

    return nodeMap[ints.first()]
}

