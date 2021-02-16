package com.leetcode

/**
 * easy
 * kotlin accumulate - fold
 */
fun largestAltitude(gain: IntArray): Int {
    return gain.fold(listOf(0)) { acc, i -> acc + (acc.last() + i) }.max()!!
}
