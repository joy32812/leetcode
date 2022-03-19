package com.leetcode

/**
 * Greedy
 */
fun maximumTop(nums: IntArray, k: Int): Int {

    if (k % 2 == 1 && nums.size == 1) return -1
    if (k == 0) return nums[0]

    if (k > nums.size) return nums.max()!!

    val a = (0 until k - 1).map { nums[it] }.max() ?: 0
    val b = if (nums.size > k) nums[k] else 0
    return Math.max(a, b)
}
