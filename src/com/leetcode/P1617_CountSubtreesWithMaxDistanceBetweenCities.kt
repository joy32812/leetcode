package com.leetcode

/**
 * O(2^n * n)
 * how to get tree diameter
 */
fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {

    val ans = mutableMapOf<Int, Int>()
    (1 until n).forEach { ans[it] = 0 }

    var diameter = 0
    fun treeDiameter(root: Int, parent: Int, edgeMap: MutableMap<Int, MutableSet<Int>>): Int {
        val childResult = mutableListOf<Int>()
        for (child in edgeMap[root]!!) {
            if (child == parent) continue
            childResult += treeDiameter(child, root, edgeMap);
        }

        childResult.sortDescending()

        if (childResult.size == 0) return 0
        if (childResult.size == 1) {
            diameter = Math.max(diameter, childResult.first() + 1)
        } else {
            diameter = Math.max(diameter, childResult[0] + childResult[1] + 2)
        }
        return childResult[0] + 1
    }

    fun work(x: Int) {
        val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
        var edgeNum = 0
        for (i in edges.indices) {
            if((x and (1 shl i)) > 0) {
                edgeNum ++
                var (u, v) = edges[i]
                u --
                v --
                edgeMap.getOrPut(u) { mutableSetOf() } += v
                edgeMap.getOrPut(v) { mutableSetOf() } += u
            }
        }
        if (edgeMap.size != edgeNum + 1) return

        diameter = 0
        treeDiameter(edgeMap.keys.first(), -1, edgeMap)

        ans[diameter] = ans[diameter]!! + 1
    }

    for (i in 0 until (1 shl (n - 1))) {
        work(i)
    }

    return (1 until n).map { ans[it]!! }.toIntArray()
}

fun main() {
    println(countSubgraphsForEachDiameter(8, arrayOf(
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 5),
            intArrayOf(2, 8),
            intArrayOf(4, 7),
            intArrayOf(6, 7),
            intArrayOf(6, 8)
    )))

    println(countSubgraphsForEachDiameter(2, arrayOf(
            intArrayOf(1, 2)
    )))

//    println("11111011".toInt(2))
}
