package com.leetcode

/**
 * bit mask
 */
fun subsetXORSum(nums: IntArray): Int {
    val N = (1 shl nums.size) - 1
    return (0..N).sumBy { mask -> nums.mapIndexed { index, d -> if (((1 shl index) and mask) > 0) d else 0 }.reduce { acc, i -> acc xor i } }
}
