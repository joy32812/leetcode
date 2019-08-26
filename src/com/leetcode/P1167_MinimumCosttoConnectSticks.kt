package com.leetcode

import java.util.*

fun connectSticks(sticks: IntArray): Int {

    val pq = PriorityQueue<Int>()
    pq.addAll(sticks.toList())

    var ans = 0

    while (pq.size > 1) {
        val now = pq.poll() + pq.poll()
        ans += now
        pq += now
    }

    return ans
}