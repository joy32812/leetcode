package com.leetcode

import java.util.*

/**
 * only handle the path from root to node (num = 1)
 */
fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
    val n = parents.size
    val ans = Array(n) { 1 }

    val numMap = nums.mapIndexed { index, i -> i to index }.toMap()
    if (1 !in numMap) return ans.toIntArray()

    val children = mutableMapOf<Int, MutableList<Int>>()
    for (i in parents.indices) {
        val p = parents[i]
        if (p == -1) continue

        children.getOrPut(p) { mutableListOf() } += i
    }

    val treeSet = TreeSet<Int>()
    (1..1_000_10).forEach { treeSet += it }

    val visited = mutableSetOf<Int>()
    var node = numMap[1]!!

    fun dfs(x: Int) {
        treeSet -= nums[x]
        for (child in (children[x] ?: mutableListOf())) {
            if (child in visited) continue
            dfs(child)
        }
    }

    while (true) {
        visited += node
        dfs(node)
        ans[node] = treeSet.first()
        if (parents[node] == -1) break
        node = parents[node]
    }

    return ans.toIntArray()
}
