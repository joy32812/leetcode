package com.leetcode

/**
 * GroupBy
 */
fun divideArray(nums: IntArray): Boolean {

    return nums.groupBy { it }.all { it.value.size % 2 == 0 }

}
