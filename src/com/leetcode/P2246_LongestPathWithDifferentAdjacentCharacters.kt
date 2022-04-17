package com.leetcode

/**
 * Tree dp.
 */
fun longestPath(parent: IntArray, s: String): Int {

    val childrenMap = mutableMapOf<Int, MutableSet<Int>>()
    for (i in parent.indices) {
        val p = parent[i]
        if (p == -1) continue

        childrenMap.getOrPut(p) { mutableSetOf() } += i
    }

    var ans = 1

    fun getLongest(root: Int): Int {
        val children = childrenMap[root] ?: mutableSetOf()

        if (children.isEmpty()) return 1

        val paths = children.map {
            val now = getLongest(it)
            if (s[root] == s[it]) 0 else now
        }.sortedDescending()

        ans = Math.max(ans, paths.take(2).sum() + 1)

        return paths.first() + 1
    }
    getLongest(0)

    return ans
}
