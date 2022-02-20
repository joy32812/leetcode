package com.leetcode

import java.util.PriorityQueue

/**
 * PQ + Greedy
 */
fun repeatLimitedString(s: String, repeatLimit: Int): String {

    val pq = PriorityQueue<Pair<Char, Int>> { a, b -> b.first - a.first }

    val gb = s.groupBy { it }.mapValues { it.value.size }
    for ((k, v) in gb) pq.add(Pair(k, v))

    val ans = StringBuilder()
    while (pq.isNotEmpty()) {
        val one = pq.poll()
        if (one.second <= repeatLimit) {
            ans.append(("" + one.first).repeat(one.second))
            continue
        }

        ans.append(("" + one.first).repeat(repeatLimit))
        if (pq.isEmpty()) break

        val two = pq.poll()
        ans.append(two.first)

        pq += Pair(one.first, one.second - repeatLimit)
        if (two.second > 1) pq += Pair(two.first, two.second - 1)
    }

    return ans.toString()
}
