package com.leetcode

/**
 * All the shortest paths have the same cost.
 */
fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {

    fun getCost(a: Int, b: Int, costs: IntArray): Int {
        if (a == b) return 0
        val (l, r) = if (a < b) Pair(a + 1, b) else Pair(b, a - 1)

        return (l..r).sumBy { costs[it] }
    }

    return getCost(startPos[0], homePos[0], rowCosts) + getCost(startPos[1], homePos[1], colCosts)
}
