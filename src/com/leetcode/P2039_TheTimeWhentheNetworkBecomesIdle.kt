package com.leetcode

import java.util.*

/**
 * Dijkstra
 * find the lastSend time for each node.
 * Then get the response time for the lastSend
 */
fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
    val n = patience.size

    val dis = Array(n) { Int.MAX_VALUE }
    fun dijkstra() {
        dis[0] = 0

        val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
        for (eg in edges) {
            edgeMap.getOrPut(eg[0]) { mutableSetOf() } += eg[1]
            edgeMap.getOrPut(eg[1]) { mutableSetOf() } += eg[0]
        }

        val Q = LinkedList<Int>()
        Q.add(0)
        val inQ = mutableSetOf<Int>()
        inQ.add(0)

        while (Q.isNotEmpty()) {
            val x = Q.poll()
            inQ.remove(x)

            val ySet = edgeMap[x] ?: mutableSetOf()
            for (y in ySet) {
                if (dis[y] > dis[x] + 1) {
                    dis[y] = dis[x] + 1
                    if (y !in inQ) {
                        inQ += y
                        Q += y
                    }
                }
            }
        }
    }
    dijkstra()

    return (1 until n).map { i -> (dis[i] * 2 - 1) / patience[i] * patience[i] + dis[i] * 2 }.max()!! + 1
}
