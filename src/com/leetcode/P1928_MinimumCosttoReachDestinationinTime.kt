package com.leetcode

import java.util.*

/**
 * Modified Dijkstra
 */
fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
    val MAX = 1001
    val n = passingFees.size
    val dp = Array(n + 1) { Array(maxTime + 1) { Int.MAX_VALUE } }

    val edgeMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    for ((from, to, time) in edges) {
        edgeMap.getOrPut(from) { mutableListOf() }.add(Pair(to, time))
        edgeMap.getOrPut(to) { mutableListOf() }.add(Pair(from, time))
    }


    val Q = LinkedList<Int>()
    val inQ = mutableSetOf<Int>()
    val city = 0
    val fee = passingFees[city]
    dp[city][0] = fee


    // city * MAX + time
    Q.add(city * MAX)
    inQ.add(city * MAX)

    var minCost = Int.MAX_VALUE

    while (Q.isNotEmpty()) {
        val now = Q.pop()

        val cid = now / MAX
        val tim = now % MAX

        if (dp[cid][tim] >= minCost) continue

        val es = edgeMap.getOrPut(cid) { mutableListOf() }

        for ((to, time) in es) {
            if (tim + time > maxTime) continue
            if (dp[cid][tim] + passingFees[to] >= dp[to][tim + time]) continue

            dp[to][tim + time] = dp[cid][tim] + passingFees[to]
            if (to == n - 1) {
                minCost = Math.min(minCost, dp[to][tim + time])
                continue
            }
            if (dp[to][tim + time] >= minCost) continue

            val key = to * MAX + tim + time
            if (key !in inQ) {
                inQ.add(key)
                Q.add(key)
            }

        }
    }

    return if (minCost == Int.MAX_VALUE) -1 else minCost
}

fun main() {

    println(
        minCost(
            30,
            arrayOf(
                intArrayOf(0, 1, 10),
                intArrayOf(1, 2, 10),
                intArrayOf(2, 5, 10),
                intArrayOf(0, 3, 1),
                intArrayOf(3, 4, 10),
                intArrayOf(4, 5, 15)
            ),
            intArrayOf(
                5, 1, 2, 20, 20, 3
            )
        )
    )

}
