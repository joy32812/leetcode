package com.leetcode

/**
 * posMap
 */
fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
    val posMap = nums.mapIndexed { i, d -> d to i }.toMap().toMutableMap()

    for ((a, b) in operations) {
        val ind = posMap[a]!!
        posMap -= a

        nums[ind] = b
        posMap[b] = ind
    }

    return nums
}
