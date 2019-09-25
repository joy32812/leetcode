package com.leetcode

import java.util.*


/**
 * Two Level TopSort
 */

fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {

    var M = m
    for (i in group.indices) {
        if (group[i] == -1) group[i] = M++
    }

    val g2item = group.withIndex().groupBy { it.value }.mapValues { it.value.map { it.index }.toSet() }
    val groupEdges = mutableSetOf<Pair<Int, Int>>()
    val itemEdgeMap = mutableMapOf<Int, MutableSet<Pair<Int, Int>>>()

    // edge
    for (i in beforeItems.indices) {
        for (j in beforeItems[i]) {

            val gi = group[i]
            val gj = group[j]

            if (gi == gj) itemEdgeMap.computeIfAbsent(gi) { mutableSetOf()}.add(Pair(j, i))
            else groupEdges.add(Pair(gj, gi))
        }
    }

    fun topSort(edges: Set<Pair<Int, Int>>, rangeSet: Set<Int>): List<Int> {
        val ans = mutableListOf<Int>()

        val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
        val inDegMap = mutableMapOf<Int, Int>()

        for ((s, t) in edges) {
            edgeMap.computeIfAbsent(s) { mutableSetOf()}.add(t)
            inDegMap[t] = (inDegMap[t] ?: 0) + 1
        }

        val Q = LinkedList<Int>()
        for (i in rangeSet) {
            if ((inDegMap[i] ?: 0) == 0) Q += i
        }

        while (!Q.isEmpty()) {
            val s = Q.poll()
            ans += s

            val edges = edgeMap.computeIfAbsent(s) { mutableSetOf()}
            for (t in edges) {
                inDegMap[t] = (inDegMap[t] ?: 0) - 1

                if (inDegMap[t] == 0) Q += t
            }
        }

        if (ans.size != rangeSet.size) return listOf()
        return ans
    }

    val groupOrder = topSort(groupEdges, (0 until M).toSet())
    if (groupOrder.isEmpty()) return intArrayOf()

    val ans = mutableListOf<Int>()
    for (i in groupOrder) {
        val now = topSort(itemEdgeMap[i] ?: setOf(), g2item[i] ?: setOf())
        if (now.size != (g2item[i] ?: setOf()).size) return intArrayOf()
        ans.addAll(now)
    }

    if (ans.size != n) return intArrayOf()
    return ans.toIntArray()
}

fun main() {
    println(sortItems(5, 5, intArrayOf(2, 0, -1, 3, 0), listOf(
            listOf(2, 1, 3),
            listOf(2, 4),
            listOf(),
            listOf(),
            listOf()
    )))

}
