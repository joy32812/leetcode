package com.leetcode

import java.util.*

/**
 * BFS
 */
fun maximalPathQuality(values: IntArray, edges: Array<IntArray>, maxTime: Int): Int {
    class Node(val id: Int, val time: Int, val visits: Set<Int>)

    class ToNode(val id: Int, val time: Int)
    val edgeMap = mutableMapOf<Int, MutableSet<ToNode>>()
    for ((u, v, time) in edges) {
        edgeMap.getOrPut(u) { mutableSetOf() } += ToNode(v, time)
        edgeMap.getOrPut(v) { mutableSetOf() } += ToNode(u, time)
    }

    fun getString(node: Node): String {
        return "" + node.id + "_" + node.time + "_" + node.visits.toSortedSet().joinToString(",")
    }

    val Q = LinkedList<Node>()
    val node0 = Node(0, 0, setOf(0))
    Q.add(node0)

    val inQ = mutableSetOf<String>()
    inQ += getString(node0)

    var ans = 0

    while (Q.isNotEmpty()) {
        val now = Q.poll()
        if (now.id == 0) {
            ans = Math.max(ans, now.visits.map { values[it] }.sum())
        }

        val toNodes = edgeMap[now.id] ?: mutableSetOf()
        for (toNode in toNodes) {
            val y = toNode.id
            val time = toNode.time

            if (now.time + time > maxTime) continue

            val newSet = now.visits.toMutableSet()
            newSet += y
            val newNode = Node(y, now.time + time, newSet)

            val nodeStr = getString(newNode)

            if (nodeStr !in inQ) {
                inQ += nodeStr
                Q += newNode
            }
        }
    }

    return ans
}
