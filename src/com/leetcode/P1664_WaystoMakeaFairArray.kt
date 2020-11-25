package com.leetcode

/**
 * prefix sum
 */
fun waysToMakeFair(nums: IntArray): Int {
    val n = nums.size
    val frontSum = Array(n) {0}
    val endSum = Array(n) {0}
    val totalSum = nums.sum()

    for (i in nums.indices) {
        frontSum[i] = nums[i] + (if (i - 2 >= 0) frontSum[i - 2] else 0)
    }
    for (i in n - 1 downTo 0) {
        endSum[i] = nums[i] + (if (i + 2 < n) endSum[i + 2] else 0)
    }


    var ans = 0
    for (i in nums.indices) {
        val left = if (i - 1 >= 0) frontSum[i - 1] else 0
        val right = if (i + 2 < n) endSum[i + 2] else 0
        if (2 * (left + right) == totalSum - nums[i]) ans ++
    }

    return ans
}


fun main() {
    println("Hello")
}
