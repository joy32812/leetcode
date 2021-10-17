package com.leetcode

import java.util.*

/**
 * Modified Dijkstra
 */
fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {

    val dis = Array(n + 1) { Array(2) { Int.MAX_VALUE } }
    dis[1][0] = 0

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for (eg in edges) {
        edgeMap.getOrPut(eg[0]) { mutableSetOf() } += eg[1]
        edgeMap.getOrPut(eg[1]) { mutableSetOf() } += eg[0]
    }


    val Q = LinkedList<Int>()
    val inQ = mutableSetOf<Int>()
    Q += 1
    inQ += 1


    while (Q.isNotEmpty()) {
        val now = Q.poll()
        inQ -= now

        val x = Math.abs(now)
        val i = if (now > 0) 0 else 1

        val ySet = edgeMap[x] ?: mutableSetOf()
        for (y in ySet) {
            val mod = dis[x][i] % (2 * change)
            val startTime = if (mod in 0 until change) dis[x][i] else dis[x][i] + 2 * change - mod
            val arriveTime = startTime + time

            if (arriveTime < dis[y][0]) {
                dis[y][0] = arriveTime
                if (y !in inQ) {
                    Q += y
                    inQ += y
                }
            } else if (arriveTime == dis[y][0]){
                // do nothing
            } else if (arriveTime < dis[y][1]) {
                dis[y][1] = arriveTime
                if (-y !in inQ) {
                    Q += -y
                    inQ += -y
                }
            }
        }
    }

    return dis[n][1]
}

fun main() {
    println(secondMinimum(
        2,
        arrayOf(
            intArrayOf(1, 2)
        ),
        3,
        2
    ))
}
