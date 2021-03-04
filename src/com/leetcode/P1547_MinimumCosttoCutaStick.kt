package com.leetcode

fun minCost(n: Int, cuts: IntArray): Int {
    val points = mutableListOf(0)
    points.addAll(cuts.sorted())
    points.add(n)

    val ansMap = mutableMapOf<String, Int>()
    fun dfs(l: Int, r: Int): Int {
        if (l + 1 == r) return 0
        val key = "" + l + "_" + r
        if (key in ansMap) return ansMap[key]!!

        var tmp = Int.MAX_VALUE
        for (i in l + 1 until r) {
            tmp = Math.min(tmp, points[r] - points[l] + dfs(l, i) + dfs(i, r))
        }

        ansMap[key] = tmp
        return tmp
    }

    return dfs(0, points.size - 1)
}
