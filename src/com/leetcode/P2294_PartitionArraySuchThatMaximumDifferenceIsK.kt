package com.leetcode

/**
 * Greedy algorithm.
 */
fun partitionArray(nums: IntArray, k: Int): Int {
    nums.sort()

    var now = nums[0]
    var cnt = 1

    for (d in nums) {
        if (d - now > k) {
            now = d
            cnt ++
        }
    }

    return cnt
}

