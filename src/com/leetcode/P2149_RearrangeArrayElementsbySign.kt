package com.leetcode

/**
 * easy
 */
fun rearrangeArray2(nums: IntArray): IntArray {

    val pos = nums.filter { it > 0 }
    val neg = nums.filter { it < 0 }

    return pos.indices.map { listOf(pos[it], neg[it]) }.flatten().toIntArray()
}
