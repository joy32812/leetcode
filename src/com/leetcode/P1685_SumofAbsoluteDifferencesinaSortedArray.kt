package com.leetcode

/**
 * prefix sum
 */
fun getSumAbsoluteDifferences(nums: IntArray): IntArray {

    val prefixSum = mutableListOf<Int>()
    nums.forEach { prefixSum += (if (prefixSum.isEmpty()) 0 else prefixSum.last()) + it }

    val ans = mutableListOf<Int>()
    for (i in nums.indices) {
        val leftNum = i
        val rightNum = nums.size - i - 1
        val left = if (leftNum > 0) leftNum * nums[i] - prefixSum[i - 1] else 0
        val right = if (rightNum > 0) prefixSum.last() - prefixSum[i] - rightNum * nums[i] else 0
        ans += left + right
    }
    return ans.toIntArray()
}
