package com.leetcode

/**
 * easy
 */
fun minimumDifference(nums: IntArray, k: Int): Int {
    nums.sort()
    return (0..nums.size - k).map { nums[it + k - 1] - nums[it] }.min()!!
}
