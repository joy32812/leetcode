package com.leetcode

import java.util.*

data class TPair(val wid: Int, val bid: Int, val dis: Int)

fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {

    val pq = PriorityQueue<TPair> {a, b -> when {
        a.dis != b.dis -> a.dis - b.dis
        a.wid != b.wid -> a.wid - b.wid
        else -> a.bid - b.bid
    }}

    for (i in 0 until workers.size) {
        for (j in 0 until bikes.size) {
            pq += TPair(i, j, Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]))
        }
    }

    val ans = mutableListOf<Pair<Int, Int>>()
    val workerSet = mutableSetOf<Int>()
    val bikeSet = mutableSetOf<Int>()
    while (!pq.isEmpty()) {
        val tPair = pq.poll()

        if (tPair.wid in workerSet) continue
        if (tPair.bid in bikeSet) continue

        ans += Pair(tPair.wid, tPair.bid)
        workerSet += tPair.wid
        bikeSet += tPair.bid
    }
    ans.sortBy { it.first }

    return ans.map { it.second }.toIntArray()
}
