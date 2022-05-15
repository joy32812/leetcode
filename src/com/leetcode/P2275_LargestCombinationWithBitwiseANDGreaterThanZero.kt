package com.leetcode

/**
 * bit-operation
 */
fun largestCombination(candidates: IntArray): Int {

    fun getCnt(i: Int) = candidates.count { it and (1 shl i) > 0 }
    return (0..25).map { getCnt(it) }.max() ?: 0
}
