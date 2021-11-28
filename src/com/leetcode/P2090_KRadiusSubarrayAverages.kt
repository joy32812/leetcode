package com.leetcode

/**
 * presum
 */
fun getAverages(nums: IntArray, k: Int): IntArray {

    val presum = Array(nums.size) { 0L }
    for (i in nums.indices) presum[i] = (if (i - 1 >= 0) presum[i - 1] else 0) + nums[i]

    fun getSum(l: Int, r: Int) = if (l - 1 < 0) presum[r] else presum[r] - presum[l - 1]
    fun getAvg(i: Int): Int {
        val l = i - k
        val r = i + k
        if (l < 0 || r >= nums.size) return -1

        return (getSum(l, r) / (r - l + 1)).toInt()
    }

    return nums.indices.map { getAvg(it) }.toIntArray()
}

