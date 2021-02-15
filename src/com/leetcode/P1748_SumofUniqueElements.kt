package com.leetcode

/**
 * easy group by
 */
fun sumOfUnique(nums: IntArray): Int {
    return nums.groupBy { it }.filterValues { it.size == 1 }.keys.sum()
}

