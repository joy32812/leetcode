package com.leetcode

import java.util.*


fun minBuildTime(blocks: IntArray, split: Int): Int {

    val pq = PriorityQueue<Pair<Int, Int>> {a, b -> a.first - b.first}
    for (b in blocks) pq += Pair(b, 0)

    var ans = blocks[0]
    while (pq.size > 1) {
        val (a1, a2) = pq.poll()
        val (b1, b2) = pq.poll()

        ans = Math.max(ans, Math.max(a1, b1) + split)
        pq += Pair(Math.max(a1, b1) + split, Math.max(a2, b2) + 1)
    }

    return ans
}

fun main() {
    println(minBuildTime(intArrayOf(1, 2), 5))
    println(minBuildTime(intArrayOf(1, 2, 3), 1))
}
