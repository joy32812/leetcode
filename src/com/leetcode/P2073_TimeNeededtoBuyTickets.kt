package com.leetcode

import java.util.*

/**
 * brute force
 */
fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {

    val line = LinkedList<Pair<Int, Int>>()
    tickets.withIndex().map { line += Pair(it.index, it.value) }

    var ans = 0
    while (line.isNotEmpty()) {
        val poll = line.poll()
        ans ++

        if (poll.first == k && poll.second == 1) return ans
        if (poll.second > 1) {
            line += Pair(poll.first, poll.second - 1)
        }
    }

    return ans
}
