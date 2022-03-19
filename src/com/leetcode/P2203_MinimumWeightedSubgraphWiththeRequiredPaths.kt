package com.leetcode

import java.util.LinkedList

/**
 * Dijkstra
 */
fun minimumWeight(n: Int, edges: Array<IntArray>, src1: Int, src2: Int, dest: Int): Long {

    class Edge(val s: Int, val t: Int, val w: Int)

    fun minDis(from: Int, edgeMap: Map<Int, List<Edge>>): List<Long> {
        val dis = (0 until n).map { Long.MAX_VALUE }.toMutableList()
        val Q = LinkedList<Int>()
        val inQ = mutableSetOf<Int>()

        dis[from] = 0L
        Q += from
        inQ += from

        while (Q.isNotEmpty()) {
            val x = Q.poll()
            inQ -= x

            val edges = edgeMap[x] ?: listOf()

            for (e in edges) {
                val t = e.t
                val w = e.w

                if (dis[t] > dis[x] + w) {
                    dis[t] = dis[x] + w

                    if (t !in inQ) {
                        Q += t
                        inQ += t
                    }
                }
            }
        }

        return dis
    }


    val e1 = edges.groupBy { it[0] }.mapValues { it.value.map { e -> Edge(e[0], e[1], e[2]) } }
    val e2 = edges.groupBy { it[1] }.mapValues { it.value.map { e -> Edge(e[1], e[0], e[2]) } }

    val d1 = minDis(src1, e1)
    val d2 = minDis(src2, e1)
    val d3 = minDis(dest, e2)

    fun getTotalDis(a1: Long, a2: Long, a3: Long) =
        if (listOf(a1, a2, a3).any { it == Long.MAX_VALUE }) Long.MAX_VALUE else a1 + a2 + a3

    val ans = (0 until n).map { getTotalDis(d1[it], d2[it], d3[it]) }.min()!!
    return if (ans == Long.MAX_VALUE) -1L else ans
}

fun main() {

    println(
        minimumWeight(
            7,
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(3, 0, 25),
                intArrayOf(4, 3, 30),
                intArrayOf(3, 4, 18),
                intArrayOf(2, 0, 17),
                intArrayOf(1, 0, 11),
                intArrayOf(4, 3, 1),
                intArrayOf(2, 0, 2),
                intArrayOf(2, 4, 18),
                intArrayOf(5, 2, 30),
                intArrayOf(0, 5, 18),
                intArrayOf(3, 2, 18),
                intArrayOf(1, 6, 2),
                intArrayOf(2, 3, 10),
                intArrayOf(3, 5, 2),
                intArrayOf(6, 2, 12),
                intArrayOf(2, 0, 29),
                intArrayOf(3, 0, 3),
                intArrayOf(5, 4, 4),
                intArrayOf(5, 1, 11)
            ),
            1,
            6,
            4
        )
    )

}


