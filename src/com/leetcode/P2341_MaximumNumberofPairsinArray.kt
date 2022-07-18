package com.leetcode

/**
 * div and mod
 */
fun numberOfPairs(nums: IntArray): IntArray {

    val list = nums.groupBy { it }.map { it.value.size }

    return intArrayOf(
        list.sumBy { it / 2 },
        list.sumBy { it % 2 }
    )
}
