package com.leetcode

/**
 * basic math.
 */
fun minimumRounds(tasks: IntArray): Int {

    val gb = tasks.groupBy { it }.mapValues { it.value.size }
    if (gb.any { it.value == 1 }) return -1

    return gb.map { it.value / 3 + (if (it.value % 3 > 0) 1 else 0) }.sum()
}
