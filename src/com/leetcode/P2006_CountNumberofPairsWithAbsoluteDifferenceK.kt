package com.leetcode

/**
 * brute force
 */
fun countKDifference(nums: IntArray, k: Int): Int {

    var total = 0
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (Math.abs(nums[i] - nums[j]) == k) total ++
        }
    }

    return total
}
