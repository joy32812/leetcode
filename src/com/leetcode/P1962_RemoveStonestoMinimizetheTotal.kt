package com.leetcode

import java.util.*

/**
 * PriorityQueue
 */
fun minStoneSum(piles: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int> { a, b -> b - a }
    piles.forEach { pq += it }

    repeat(k) {
        val top = pq.poll()
        pq += top - (top / 2)
    }

    return pq.toList().sum()
}
