package com.leetcode

/**
 * greedy
 */
fun numberOfWeeks(milestones: IntArray): Long {

    val longMiles = milestones.map { it.toLong() }

    val max = longMiles.max()!!
    val left = longMiles.sum() - max

    return if (max > left + 1) 2 * left + 1 else left + max
}
