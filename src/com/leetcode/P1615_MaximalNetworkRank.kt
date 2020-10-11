package com.leetcode

/**
 * brute force O(n^2)
 * Check if node i and j is connected.
 */
fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {

    val edges = mutableMapOf<Int, MutableSet<Int>>()
    for (i in roads.indices) {
        val (u, v) = roads[i]
        if (!edges.containsKey(u)) edges[u] = mutableSetOf()
        if (!edges.containsKey(v)) edges[v] = mutableSetOf()
        edges[u]!! += i
        edges[v]!! += i
    }

    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            val setI = if (edges.containsKey(i)) edges[i]!! else mutableSetOf()
            val setJ = if (edges.containsKey(j)) edges[j]!! else mutableSetOf()
            ans = Math.max(ans, (setI union setJ).size)
        }
    }

    return ans
}

fun main() {
    
}
