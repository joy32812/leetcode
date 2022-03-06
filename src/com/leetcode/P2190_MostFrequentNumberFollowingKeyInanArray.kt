package com.leetcode

/**
 * easy
 */
fun mostFrequent(nums: IntArray, key: Int): Int {
    fun getNumber(d: Int) = (0 until nums.size - 1).count { nums[it] == key && nums[it + 1] == d }
    return nums.toSet().maxBy { getNumber(it) }!!
}

